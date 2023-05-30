package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class StorageActivity : AppCompatActivity() {

    private lateinit var storageRef: StorageReference
    private lateinit var imageView: ImageView
    private lateinit var downloadButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        // Create a storage reference from our app
        storageRef = FirebaseStorage.getInstance().reference

        // Get the image view
        imageView = findViewById(R.id.imageView)

        // Create the download button
        downloadButton = Button(this)
        downloadButton.text = "Download"

        // Set the download button listener
        downloadButton.setOnClickListener {
            // Download the image
            storageRef.child("images/my_image.jpg").getBytes(1024 * 1024).addOnSuccessListener { bytes ->
                // Convert the bytes to a bitmap
                val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)

                // Set the image view to the bitmap
                imageView.setImageBitmap(bitmap)
            }.addOnFailureListener {
                // Handle any errors
                Log.e("StorageActivity", "Error downloading image", it)
            }
        }

        // Add the download button to the layout
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        downloadButton.layoutParams = layoutParams
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        linearLayout.addView(downloadButton)
    }
}
