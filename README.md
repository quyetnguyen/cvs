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
