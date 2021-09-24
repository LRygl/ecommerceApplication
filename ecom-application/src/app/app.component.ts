import { Component, OnInit } from '@angular/core';
import { Manufacturer } from './manufacturer/Manufacturer.ts';
import { ManufacturerServiceService } from './services/manufacturer-service.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ecom-application';
  manufacturers = Manufacturer[];

  constructor(private router:Router, private manufacturerService: ManufacturerServiceService){}

  getManufacturers(){
    this.manufacturerService.getManufacturers().subscribe(data => {this.manufacturers = data})
  }
}
