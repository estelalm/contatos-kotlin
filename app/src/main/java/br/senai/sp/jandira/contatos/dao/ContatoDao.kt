package br.senai.sp.jandira.contatos.dao

import androidx.room.Dao
import androidx.room.Insert
import br.senai.sp.jandira.contatos.model.Contato


// interface que diz ao room o que ele fará no banco
// não é necessário implementar
@Dao
interface ContatoDao {

    //salvar o contato que é do tipo da classe Contato e anotar como insert
    @Insert
    fun salvar(contato: Contato): Long


}