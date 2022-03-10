// Samriddhi Dashora

import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { delay, switchMap } from 'rxjs/operators';
import { DataServiceService } from '../data-service.service';
import { EventForRecordService } from '../event-for-record.service';
import { timer } from 'rxjs';

@Component({
  selector: 'app-acknowledgement',
  templateUrl: './acknowledgement.component.html',
  styleUrls: ['./acknowledgement.component.css']
})
export class AcknowledgementComponent implements OnInit {

  private readonly _eventService: EventForRecordService;
  message:any ={};


  constructor(private dataService: DataServiceService, private eventService: EventForRecordService) { 
    this._eventService = eventService;
    this._eventService.emitter.subscribe( message => this.message = message);
    console.log(this.message);
  }

  @Output() displayPageName = new EventEmitter<String>();

  @Output() recordData = new EventEmitter<String>();

  ngOnInit(): void {
    window.scrollTo(0, 0);
    this.getRecords();
  }

  recordList: any;


  getRecords():void{
    timer(2000).pipe(
      switchMap(() => this.dataService.getSurveyRecords()),
     ).subscribe((records) => {console.log(this.recordList = records)});
    console.log("This is acknowledge component TypeScript");
     //this.dataService.getSurveyRecords().pipe().subscribe((records) => {console.log(this.recordList = records)});
  }

  backToHomePage(){
    this.displayPageName.emit("homePage");
  }

  displayPage(pageName: String){
    console.log(pageName);
    this.displayPageName.emit(pageName);
  }

  loadReadOnlyFormm(message: any){
    console.log(message);
    this._eventService.broadcastMessage(message);
    this.displayPageName.emit(message);
  }

  onCancel(){
    this.displayPageName.emit("showStudentSurveyForm");
  }

}
