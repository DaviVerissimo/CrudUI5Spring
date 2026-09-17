import {
  Component,
  CUSTOM_ELEMENTS_SCHEMA,
  OnInit,
  ChangeDetectorRef
} from '@angular/core';

import { CommonModule } from '@angular/common';
import "@ui5/webcomponents/dist/Button.js";

import { Usuario } from '../../models/usuario';
import { UsuarioService } from '../../services/service';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.html',
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class HomeComponent implements OnInit {

  usuarios: Usuario[] = [];

  carregando = true;

  novoUsuario = {
    nome: '',
    email: ''
  };

  nomeUsuario = '';
  emailUsuario = '';

  dialogAberto = false;

  constructor(
    private usuarioService: UsuarioService,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit(): void {

    this.usuarioService
      .listar()
      .subscribe({

        next: (usuarios) => {
          console.log('Recebidos:', usuarios);
          console.log('NEXT');
          this.usuarios = usuarios;
          this.carregando = false;

          this.cdr.detectChanges();

        },

        error: (erro) => {
          console.log('ERROR');
          console.error(erro);
          this.carregando = false;

        }

      });

  }

  adicionarUsuario(): void {

    this.dialogAberto = true;

  }

  fecharDialog(): void {

    this.dialogAberto = false;

  }

salvarUsuario(
  nome: string,
  email: string
): void {

  console.log({
    nome,
    email
  });

    this.dialogAberto = false;

  }

}