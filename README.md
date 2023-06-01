# Firebase Image Upload Android App

This Android app allows users to upload pictures to Firebase Storage and displays the uploaded pictures in a list view. The app is built using Kotlin and utilizes Firebase services for image storage and Firestore for data management.

## Features

- Image selection: Users can select images from their device gallery using the app.
- Image upload: Selected images are uploaded to Firebase Storage.
- Image display: The app fetches the uploaded images from Firestore and displays them in a list view.
- Progress indication: The app shows a progress bar during image upload to indicate the upload status.
- Error handling: Appropriate error messages are displayed to the user in case of upload or data retrieval errors.

## Requirements

- Android device or emulator running Android 5.0 (API level 21) or above.
- Internet connectivity for accessing Firebase services.

## Installation

1. Clone the repository or download the source code to your local machine.
2. Open the project in Android Studio.
3. Connect your Android device or start an emulator.
4. Build and run the app on the device or emulator.

Note: Ensure that you have set up Firebase services and added the necessary configuration files to the project. Refer to the Firebase documentation for detailed instructions on setting up Firebase in your Android app.

## Usage

1. Launch the app on your Android device or emulator.
2. The main screen displays buttons for image upload and image display.
3. To upload an image:
   - Tap on the "Upload" button.
   - Select an image from your device gallery.
   - The progress bar indicates the upload progress.
   - Upon successful upload, a toast message is displayed.
4. To view uploaded images:
   - Tap on the "Show All" button.
   - The app fetches the uploaded images from Firestore and displays them in a list view.
5. To select a different image for upload:
   - Tap on the image view on the main screen.
   - Select a new image from your device gallery.

## Configuration

Before running the app, make sure to perform the following configuration steps:

1. Set up Firebase project and services:
   - Create a new Firebase project in the Firebase console.
   - Enable Firebase Storage and Firestore services for the project.
   - Obtain the necessary configuration files (google-services.json) and add them to the app module in the project.
   - Refer to the Firebase documentation for detailed instructions on setting up Firebase services in your Android app.

2. Update package name and dependencies:
   - Update the package name in the AndroidManifest.xml file and any other necessary files to match your project's package name.
   - Update the app-level build.gradle file with the appropriate dependencies and versions for Firebase services and other libraries used.

3. Enable storage rules:
   - Configure the security rules for Firebase Storage to allow read and write access as per your app's requirements.

## Contributing

Contributions to the project are welcome! If you have any bug fixes, feature enhancements, or suggestions, please submit a pull request or open an issue on the project repository.

When contributing, please ensure the following:

- Follow the existing code style and conventions.
- Write clear and concise commit messages.
- Provide detailed information about the changes in the pull request or issue description.

## License

The Firebase Image Upload Android App is open-source software released under the MIT License. You are free to use, modify, and distribute the code for personal and commercial purposes.
