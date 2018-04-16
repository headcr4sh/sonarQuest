import {Component, OnInit} from '@angular/core';
import {Developer} from '../../Interfaces/Developer';
import {DeveloperService} from '../../services/developer.service';
import {MatDialog} from "@angular/material";
import {AvatarEditComponent} from "./components/my-avatar-edit/my-avatar-edit.component";

@Component({
  selector: 'app-my-avatar-page',
  templateUrl: './my-avatar-page.component.html',
  styleUrls: ['./my-avatar-page.component.css']
})
export class MyAvatarPageComponent implements OnInit {

  public developer: Developer;
  public XPpercent: number = 0;
  public level: number;

  constructor(
    private developerService: DeveloperService, 
    private dialog: MatDialog
  ) { }

  ngOnInit() {
    this.developerService.avatar$.subscribe(developer => {
      this.developer = developer;
      this.level = this.developerService.getLevel(developer.xp)
      this.xpPercent();
    })
  }

  private createSkillsList(artefact: any) {
    const skillnames = artefact.skills.map(skill => skill.name);
    return skillnames.join(', ');
  }

  public xpPercent(): void {
    this.XPpercent = 100 / this.developer.level.max * this.developer.xp;
    this.XPpercent.toFixed(2);
  }

  public editAvatar(): void {
    this.dialog.open(AvatarEditComponent, {data: this.developer, width: "500px"}).afterClosed().subscribe(
      result => {
        if(result) {
          this.developer = result;
        }
      }
    );
  }
}
