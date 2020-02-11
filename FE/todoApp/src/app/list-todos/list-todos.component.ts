import { Component, OnInit, ViewChild } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {
  todos: Array<any> = [];
  dataSource: any;
  displayedColumns: string[] = ['id', 'description', 'done', 'targetDate'];

  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor() { }

  ngOnInit() {
    this.todos = [
      new TodoModel(1,"learning spring boot", false, new Date()),
      new TodoModel(2,"learning angular", true, new Date()),
      new TodoModel(3,"learning c#", false, new Date()),
      new TodoModel(4,"learning html", true, new Date()),
      new TodoModel(5,"learning css", false, new Date()),
      new TodoModel(6,"learning spring mvc", true, new Date()),
    ]
    this.dataSource = new MatTableDataSource(this.todos);
    this.dataSource.sort = this.sort;
  }

}

export class TodoModel {
  public id: number
  public description: string
  public done: boolean
  public targetDate: Date

  constructor(id: number, description: string, done: boolean, targetDate: Date) {
    this.id = id
    this.description = description
    this.done = done
    this.targetDate = targetDate
   }
}
