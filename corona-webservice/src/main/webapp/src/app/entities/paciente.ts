import {Endereco} from "./endereco";
import {PessoaSexo} from "./pessoa-sexo.enum";

export class Paciente {
  nome: string;
  sobrenome: string;
  dataNascimento?: Date;
  email: string;
  cpf?: string;
  rg?: string;
  sexo: PessoaSexo;
  endereco: Endereco;
  pcd: boolean;
  email: string;
}
