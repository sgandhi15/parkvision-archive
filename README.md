# ParkVision - Smart Parking Management System

## Project Overview

ParkVision is an Android mobile application designed to bring efficiency and convenience to parking management systems. The app enables users to monitor parking spaces in real-time and receive notifications when parking spaces become available or occupied.

## Key Features

- **Real-time Parking Space Monitoring**: View the status of up to four parking spaces in real-time
- **Notification System**: Subscribe to specific parking spaces to receive notifications when they become available or occupied
- **User Authentication**: Secure phone number-based authentication using Firebase Authentication and AWS Cognito
- **User Profiles**: Create and manage user profiles with customizable information and profile pictures
- **Intuitive UI**: Clean and user-friendly interface with visual indicators for parking space status

## Technical Details

- **Platform**: Android Native
- **Backend**: AWS DynamoDB for data storage and synchronization
- **Authentication**: Firebase Authentication for enhanced security
- **Notifications**: Firebase Cloud Messaging for reliable real-time push notifications
- **Storage**: Firebase Storage for scalable media storage
- **Minimum SDK**: Android 5.0 (Lollipop)
- **Cloud Infrastructure**: AWS for scalable backend operations and analytics

## System Architecture

The application follows a client-server architecture where:

- The Android app serves as the client interface
- Firebase and AWS provide the backend services including database, authentication, and notification
- AWS Lambda functions process business logic and handle scaling
- Real-time synchronization allows for immediate updates across devices

## Implementation Highlights

- **Offline Capability**: The app uses Firebase's persistence feature to ensure functionality even when offline
- **Real-time Synchronization**: Changes in parking space availability are immediately reflected across all user devices
- **Topic-based Notifications**: Users can subscribe to specific parking spaces to receive targeted notifications
- **User Data Persistence**: User sessions are maintained using SharedPreferences for seamless experience
- **Cloud Processing**: AWS cloud services handle data processing and analytics in the background

## Getting Started

1. Clone the repository
2. Connect the project to your Firebase project and AWS account
3. Configure Firebase Authentication and Cloud Messaging
4. Set up necessary AWS services (DynamoDB)
5. Build and run the application on your Android device or emulator

## Dependencies

- Firebase Authentication
- Firebase Realtime Database
- Firebase Cloud Messaging
- AWS SDK for Android
- AWS Amplify
- CircleImageView
- Material EditText
- Glide for image loading and caching

## Future Enhancements

- Integration with payment gateways for paid parking
- GPS-based navigation to available parking spaces
- Statistical analysis of parking usage patterns using AWS Analytics
- Multiple parking lot management with AWS IoT Core integration
- Predictive parking availability using AWS Machine Learning services

## Project Status

Active development

---

This smart parking solution demonstrates the effective use of IoT concepts and mobile technology to solve urban transportation challenges by making parking more efficient and user-friendly.
