import { Component } from '@angular/core';

@Component({
    selector: 'trigger-layout',
    templateUrl: `./layout.component.html`,
    styleUrls  : [`./layout.component.css`]
})

export class TriggerLayoutComponent {
    isCollapsed = false;
}