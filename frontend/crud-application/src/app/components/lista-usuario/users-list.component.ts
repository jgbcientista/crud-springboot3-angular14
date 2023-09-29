import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../service/Usuario.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss'],
})
export class UsersListComponent implements OnInit {
  Users: any = [];

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.usuarioService.obterTodos().subscribe((res: any) => {
      console.log(res);
      this.Users = res;
    });
  }

  delete(id: any, i: any) {
    console.log(id);
    if (window.confirm('Tem certeza que deseja remover?')) {
      this.usuarioService.removerUsuario(id).subscribe(() => {
        this.Users.splice(i, 1);
      });
    }
  }
}
