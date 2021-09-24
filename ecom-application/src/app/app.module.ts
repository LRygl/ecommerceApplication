import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddManufacturerComponent } from './manufacturer/add-manufacturer/add-manufacturer.component';

@NgModule({
  declarations: [
    AppComponent,
    AddManufacturerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
