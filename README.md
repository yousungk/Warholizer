[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/WiZiZvnm)

# WARHOLIZER

Warholizer is a pop-art image converter that paints black and white images with Andy Warhol's inspired colors. With an interactive Java GUI, users can upload images of their choice and view the converted image directly on the application.

The main motivation of our application was to learn more about the underlying mechanism behind image processing algorithms while adding a “colorful” twist to visualization.

## Running the Project Locally
1. Download and navigate to src folder
2. Open the files on an IDE (ex. IntelliJ)
3. Navigate to WarholizerApp and start program
4. Click on upload image button to load an image (should be a black and white image for optimal result)
5. Click on "Warholize" button to convert image

## Application Features
- Upload image button
  - Users can upload image of their choice.
    
- Warholize button
  - This will repaint the image. The updated image will be shown on screen.

## Main Algorithm and Data Structure
Our main algorithm and data structure is UNION FIND. After grayscaling the uploaded image, we iterate through image pixels, where for each pixel, we look at its neighboring pixel and UNION if the pixel and the neighboring pixel are of the same color.

After creating clusters of identical, contiguous pixels, we assign a unique ID to each cluster and also save the size of each cluster. We use the cluster size as the KEY to the hash table of (cluster size, Andy Warhol color).

## Design Patterns
- MVC (Model View Controller)
- Abstract Factory
- Singleton

## Example 
Original Image:

<img width="593" alt="Original" src="https://github.com/upenn-cit594/cit-5940-final-project-kim/assets/139073954/7c80fef3-b0e8-462c-8b42-4996445e588c">

Converted Image:

<img width="592" alt="Screen Shot 2024-05-08 at 3 53 21 PM" src="https://github.com/upenn-cit594/cit-5940-final-project-kim/assets/139073954/2f4a87ca-7ae7-4e0f-8192-8e092fa1458d">



