package lotsu.alfred.asyncwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch{
            Log.i("MyTag", "Calculation started")
            val stock1 = async { getStock1() }
            val stock2 = async { getStock2() }
            val sum = stock1.await() + stock2.await()
            Log.i("MyTag", sum.toString())

        }
    }

    private suspend fun getStock1(): Int {
        delay(10000)
        Log.i("MyTag", "stock1 returned")
        return 25000
    }

    private suspend fun getStock2(): Int {
        delay(8000)
        Log.i("Mytag", "stock2 returned")
        return 35000
    }
}