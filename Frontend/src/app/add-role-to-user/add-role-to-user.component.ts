import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../model/user.model';
import { Role } from '../model/role.model';

@Component({
  selector: 'app-add-role-to-user',
  templateUrl: './add-role-to-user.component.html',
  styleUrls: ['./add-role-to-user.component.css'],
})
export class AddRoleToUserComponent implements OnInit {
  constructor(
    private userService: UsersService,
    private activatedRoute: ActivatedRoute
  ) {}

  user!: User;
  users: User[] = [];
  role!: Role;
  roles: Role[] = [];
  roleId!: number;
  newRole!: Role;
  oldRole!: Role;

  ngOnInit(): void {
    this.loadUserAndRoles();
  }

  loadUserAndRoles() {
    this.userService.usersList().subscribe((users) => {
      this.users = users;
    });

    this.userService
      .getUserById(this.activatedRoute.snapshot.params['id'])
      .subscribe((user) => {
        this.user = user;
      });

    this.userService.getAllRoles().subscribe((roles) => {
      this.roles = roles;
    });
  }

  addRoleToUser() {
    this.userService
      .addRoleToUser(this.user.user_id, this.newRole)
      .subscribe((data) => {
        console.log('Role added to user');
        this.user.roles.push(this.newRole); // Add the new role to the user's roles
      });
  }

  removeRoleFromUser(id: number) {
    console.log('ROLE ID: ' + id);
    this.userService.getRoleById(id).subscribe((role) => {
      this.roleId = role.role_id;
      this.oldRole = role;
      console.log('OLD ROLE: ' + this.oldRole);
      this.userService
        .removeRoleFromUser(this.user.user_id, this.oldRole)
        .subscribe((data) => {
          console.log('Role removed from user');
          // Remove the role from the user's roles array
          this.user.roles = this.user.roles.filter(
            (userRole) => userRole.role_id !== id
          );
        });
    });
  }
}
