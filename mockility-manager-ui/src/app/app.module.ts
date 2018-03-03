import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {NgZorroAntdModule} from "ng-zorro-antd";
import {TriggerLayoutComponent} from "./layout/layout.component";

@NgModule({
  declarations: [
    AppComponent,
    TriggerLayoutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgZorroAntdModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
