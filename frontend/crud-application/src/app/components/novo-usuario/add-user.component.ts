import { Component, OnInit, NgZone } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from '../../service/Usuario.service';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss'],
})
export class AddUserComponent implements OnInit {
  userForm: FormGroup;

  constructor(
    public formBuilder: FormBuilder,
    private router: Router,
    private ngZone: NgZone,
    private usuarioService: UsuarioService
  ) {
    this.userForm = this.formBuilder.group({
      nome: [''],
      email: [''],
      login: [''],
      senha: [''],
    });
  }

  ngOnInit() {}


  onSubmit(): any {
    let usuario = {'usuario': this.userForm.value};

    this.usuarioService.adicionarNovo(usuario).subscribe(
      () => {
        console.log('Dados salvo com sucesso');
        this.ngZone.run(() => this.router.navigateByUrl('/users-list'));
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
