import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule, NgIf } from '@angular/common';

@Component({
  selector: 'app-image-upload',
  standalone: true,
  imports: [FormsModule, HttpClientModule, NgIf, CommonModule],
  templateUrl: './upload-image.component.html',
  styleUrls: ['./upload-image.component.css'],
})

export class UploadImageComponent {
  constructor(private httpClient: HttpClient) { }


  title = 'ImageUploaderFrontEnd';

  public selectedFile:any;
  public event1:any;
  imgURL: any;
  receivedImageData: any;
  base64Data: any;
  convertedImage: any;

  public onFileChanged(event:Event) {
    console.log(event);

    if (event.target instanceof HTMLInputElement && event.target.files) 
      this.selectedFile = event.target.files[0];


    // Below part is used to display the selected image
    let reader = new FileReader();
    reader.readAsDataURL(this.selectedFile);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };

  }


  // This part is for uploading
  onUpload() {


    const uploadData = new FormData();
    uploadData.append('myFile', this.selectedFile, this.selectedFile.name);


    this.httpClient.post('http://localhost:8080/image-upload/upload', uploadData)
      .subscribe(
        res => {
          console.log(res);
          this.receivedImageData = res;
          this.base64Data = this.receivedImageData.pic;
          this.convertedImage = 'data:image/jpeg;base64,' + this.base64Data;
        },
        err => console.log('Error Occured duringng saving: ' + err)
      );


  }
}
