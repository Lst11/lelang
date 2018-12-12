import com.example.data.db.entity.WordDB
import com.example.data.utils.Transformer
import com.example.domain.entity.Word

fun WordDB.transformToDomain(): Word {
    return Word(wordPL = wordPL, wordRU = wordRU.toMutableList())
}


