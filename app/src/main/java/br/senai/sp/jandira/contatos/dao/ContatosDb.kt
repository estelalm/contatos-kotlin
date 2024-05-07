package br.senai.sp.jandira.contatos.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.contatos.model.Contato



// contatosDb extends RoomDatabase (herda a classe abstrata)
//quais classes serão entidades do banco de dados (contatos)
@Database(entities = [Contato::class], version = 1)
abstract class ContatoDb : RoomDatabase (){

    abstract fun contatoDao(): ContatoDao

    //mesma coisa do static do java
    companion object {
        //lateinit: espara algo acontecer para depois funcionar (  como o await  )
        private lateinit var instancia: ContatoDb

        fun getBancoDeDados(context: Context): ContatoDb {
            instancia = Room
                .databaseBuilder(
                    context,  // contexto passado na chamada da função
                    ContatoDb::class.java, // instancia o contatosdb
                    "db_contatos" // nome do banco
                )
                .allowMainThreadQueries()  // permitir chamar o banco de dados na mesma thread que controla a interface gráfica
                .fallbackToDestructiveMigration()  // ignora a versão do banco, destrói ao invés de fazer a migração
                .build()

            return instancia
        }
    }

}