package br.senai.sp.jandira.contatos.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.contatos.model.Contato
import org.intellij.lang.annotations.JdkConstants.TreeSelectionMode


// interface que diz ao room o que ele fará no banco
// não é necessário implementar
@Dao
interface ContatoDao {

    //salvar o contato que é do tipo da classe Contato e anotar como insert
    @Insert
    fun salvar(contato: Contato): Long

    @Query("SELECT * FROM tbl_contato ORDER BY nome ASC")
    fun listarTodosOsContatos(): List<Contato>

    //passar o parâmetro id na query
    @Query("SELECT * FROM tbl_contato WHERE id = :id")
    fun buscarContatoPeloId(id:Long): Contato

}