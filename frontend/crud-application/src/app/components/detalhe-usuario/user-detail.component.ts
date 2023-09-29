import { Component, OnInit, NgZone } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UsuarioService } from '../../service/Usuario.service';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.scss'],
})
export class UserDetailComponent implements OnInit {
  getId: any;
  updateForm: FormGroup;

  constructor(
    public formBuilder: FormBuilder,
    private router: Router,
    private ngZone: NgZone,
    private activatedRoute: ActivatedRoute,
    private usuarioService: UsuarioService
  ) {
    this.getId = this.activatedRoute.snapshot.paramMap.get('id');

    this.usuarioService.obterUsuarioPorId(this.getId).subscribe((res: { [x: string]: any; }) => {
      this.updateForm.setValue({
        nome: res['nome'],
        email: res['email'],
        login: res['login'],
        senha: res['senha'],
      });
    });

    this.updateForm = this.formBuilder.group({
      nome: [''],
      email: [''],
      login: [''],
      senha: [''],
    });
  }

  ngOnInit() {}

  onUpdate(): any {
    this.usuarioService.atualizarUsuario(this.getId, this.updateForm.value).subscribe(
      () => {
        console.log('Dados atualizado com sucesso!');
        this.ngZone.run(() => this.router.navigateByUrl('/users-list'));
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
