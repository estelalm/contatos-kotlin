package br.senai.sp.jandira.contatos.dao

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.contatos.model.Contato



// contatosDb extends RoomDatabase (herda a classe abstrata)
@Database(entities = [Contato::class], version = 1)
abstract class ContatosDb : RoomDatabase (){

    abstract fun contatoDao(): ContatoDao

    //mesma coisa dos atatic do java
    companion object

}