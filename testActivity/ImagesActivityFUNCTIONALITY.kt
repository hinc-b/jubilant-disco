package com.example.imageuploader

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.ImagesAdapter
import com.example.myapplication.databinding.ActivityImagesBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ImagesActivityFUNCTIONALITY : AppCompatActivity() {

    private lateinit var binding: ActivityImagesBinding
    private lateinit var storageRef: StorageReference
    private lateinit var firebaseFirestore: FirebaseFirestore
    private var mList = mutableListOf<String>()
    private lateinit var adapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initVars()
        getImages()
        registerClickEvents()
    }

    private fun registerClickEvents() {
        binding.SelectBtn.setOnClickListener {
            performActionOnSelectedItems()
        }
    }



    private fun initVars() {
        storageRef = FirebaseStorage.getInstance().reference.child("Images")
        firebaseFirestore = FirebaseFirestore.getInstance()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ImagesAdapter(mList)
        binding.recyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getImages() {
        firebaseFirestore.collection("images")
            .get().addOnSuccessListener { result ->
                for (document in result) {
                    val imageUrl = document.data["pic"].toString()
                    mList.add(imageUrl)
                }
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }
    }


    private fun performActionOnSelectedItems() {
        val selectedItems = mList.filterIndexed { index, _ ->
            adapter.isItemSelected(index)
        }
        for (item in selectedItems) {
            // Perform delete action on selected item
            deleteItemFromFirestore(item)
        }
    }

    private fun deleteItemFromFirestore(item: String) {
        // Delete the item from Firestore based on your implementation
        // Here's an example of how you can delete a document from a collection
        firebaseFirestore.collection("images")
            .whereEqualTo("pic", item)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    document.reference.delete()
                        .addOnSuccessListener {
                            // Deletion successful
                            // Delete the corresponding image file from Firebase Storage
                            deleteImageFromStorage(item)
                        }
                        .addOnFailureListener { e ->
                            // Error occurred during deletion
                        }
                }
            }
    }

    private fun deleteImageFromStorage(imageUrl: String) {
        // Get the reference to the Firebase Storage file
        val storageRef = FirebaseStorage.getInstance().getReferenceFromUrl(imageUrl)

        // Delete the file
        storageRef.delete()
            .addOnSuccessListener {
                // Image file deleted successfully
            }
            .addOnFailureListener { e ->
                // Error occurred while deleting the image file
            }
    }
}

private fun <E> MutableList<E>.filterIndexed(predicate: (index: Int, E) -> Unit): List<E> {
    TODO("Not yet implemented")
}
