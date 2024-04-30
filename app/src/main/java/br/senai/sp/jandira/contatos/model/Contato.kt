package br.senai.sp.jandira.contatos.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.intellij.lang.annotations.Identifier
import org.jetbrains.annotations.NotNull

@Entity(tableName = "tbl_contato")
data class Contato(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val nome: String = "",
    var telefone: String = "",
    val email: String = "",
    @ColumnInfo(name = "data_nascimento") val dataNascimento: String = "",
    @ColumnInfo(name = "is_familia") var isFamilia: Boolean = false
)
