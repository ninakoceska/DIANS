import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { SignupPageComponent } from './signup-page/signup-page.component';
import { wineryComponent } from './winery/winery.component';
import { UploadImageComponent } from './upload-image/upload-image.component';

const routerConfig: Routes = [

  { path: '', component: HomeComponent, title: "Home Page" },
  { path: 'wineries', component: wineryComponent, title: "Wineries" },
  { path: 'loginPage', component: LoginPageComponent, title: "LoginPage" },
  { path: 'singUpPage', component: SignupPageComponent, title: "SignUpPage" },
  { path: 'imageUploadPage', component: UploadImageComponent, title: "ImageUploadPage" }
]

export default routerConfig;
