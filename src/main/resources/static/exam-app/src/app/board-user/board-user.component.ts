import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import {ExamService} from "../service/exam.service";

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {

  content: string;

  constructor(private userService: UserService, private examService : ExamService) { }

  ngOnInit(): void {
    this.examService.examResult({username: localStorage.getItem('username')}).subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

}
