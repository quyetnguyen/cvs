## Architecture and Design

This project is built using the **MVVM** architecture, for clear separation of concerns, making the codebase easier to maintain and test

### Key Technologies
- **Jetpack Compose** for UI
- **Hilt** for DI
- **Retrofit** for Network
- **Coil** for Image Loading
- **Kotlin Coroutines** for Asynchronous tasks

---

## Features

### **Core Features**
- [x] **Search Images**: Allows users to search for images using either a single word or multiple comma-separated tags
  - [x] Results are updated dynamically with every keystroke
  - [x] The search bar is prominently placed at the top, with results displayed below in a list or grid format
- [x] **Display Thumbnails**: Retrieves and displays image thumbnails in the search results
- [x] **Detail View**: Provides a detailed view when an image is selected, displaying:
  - [x] full image
  - [x] title
  - [x] image's width and height
  - [x] metadata retrieved from the API
- [x] **Material Design Compliance**: Follows Google's Material Design principles to create an intuitive and visually appealing user interface
- [x] **Responsiveness**: Ensures all API calls and operations run off the main thread, maintaining a smooth user experience

### **Nice-to-Have Features**
- [x] **Landscape Orientation Support**: Works seamlessly in both portrait and landscape modes
- [x] **Dynamic Scaling**: Adapts text and UI elements to user scaling preferences
- [x] **Accessibility**: Fully supports TalkBack, ensuring accessibility for users with disabilities
- [ ] **Unit Tests**: Includes unit tests for the repository and ViewModel layers to validate core functionality
- [x] **Share Button**: A button in the detail view lets users share the image along with its metadata
- [ ] **Image Transition Animation**: Provides smooth animations between the list/grid view and the detail view




| Search Screen | Detail View  | Share Button View |
|----------------------|-------------|-------------|
|  <img src="https://github.com/user-attachments/assets/44d7b0f8-69e7-4caa-b4c8-7abc9151c6b8" alt="Search Screen" width="300" />  | <img src="https://github.com/user-attachments/assets/6bf3baf1-ac95-4cb0-93d8-5882be35ab7a" alt="Detail View" width="300" /> | <img src="https://github.com/user-attachments/assets/2d158403-9795-4cc0-82a5-7d64334d4a7b" alt="Share" width="300" /> |


| Dynamic Scaling | Landscape Orientation |
|----------------------|-------------|
|  <img src="https://github.com/user-attachments/assets/991463d7-6d27-495a-9a11-f10e57b375cc" alt="Scaling" width="300" />  | <img src="https://github.com/user-attachments/assets/2bba7441-9de1-44ca-a4bc-04931e21cde3" alt="Landscape" height="300" /> |
