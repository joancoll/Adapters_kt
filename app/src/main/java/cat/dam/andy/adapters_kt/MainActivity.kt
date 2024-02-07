package cat.dam.andy.adapters_kt

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //member variables
    lateinit var lv_fruits: ListView
    lateinit var sp_fruits: Spinner
    lateinit var sp_fruits_custom: Spinner
    var fruitsNames = arrayOf(
        "Apple",
        "Banana",
        "Litchi",
        "Mango",
        "PineApple",
        "Orange",
        "Grapes"
    ) //fruit names array
    var fruitsImages = intArrayOf(
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.litchi,
        R.drawable.mango,
        R.drawable.pineapple,
        R.drawable.orange,
        R.drawable.grapes
    ) //fruits images

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initArrayAdapter()
        initCustomBaseAdapter()
        initSimpleAdapter()
        initListeners()
    }

    private fun initViews() {
        lv_fruits = findViewById<ListView>(R.id.lv_fruits)
        sp_fruits = findViewById<Spinner>(R.id.sp_fruits)
        sp_fruits_custom = findViewById<Spinner>(R.id.sp_fruits_custom)
    }

    private fun initArrayAdapter() {
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, fruitsNames)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp_fruits.adapter = arrayAdapter
        sp_fruits.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, pos: Int, id: Long) {
                Toast.makeText(applicationContext, fruitsNames[pos], Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun initCustomBaseAdapter() {
        val customAdapter = CustomAdapter(applicationContext, fruitsImages, fruitsNames)
        sp_fruits_custom.adapter = customAdapter

        sp_fruits_custom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                val selectedFruit = fruitsNames[pos]
                Toast.makeText(applicationContext, selectedFruit, Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun initSimpleAdapter() {
        val arrayList = ArrayList<HashMap<String, Any?>>()
        for (i in fruitsNames.indices) {
            val hashMap = HashMap<String, Any?>()
            hashMap["name"] = fruitsNames[i]
            hashMap["image"] = fruitsImages[i]
            arrayList.add(hashMap)
        }
        val from = arrayOf("name", "image")
        val to = intArrayOf(R.id.tv_fruit_name, R.id.iv_fruit_image)
        val simpleAdapter = SimpleAdapter(this, arrayList, R.layout.custom_listview_item, from, to)
        lv_fruits.adapter = simpleAdapter
    }

    private fun initListeners() {
        lv_fruits.onItemClickListener =
            OnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
                Toast.makeText(
                    this@MainActivity,
                    fruitsNames[position],
                    Toast.LENGTH_SHORT
                ).show()
            }
    }
}