package com.foodhub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private  lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<Food>
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this)

        foodList =ArrayList()

        foodList.add(Food(R.drawable.beef,"Beef "))
        foodList.add(Food(R.drawable.fish,"Fish"))
        foodList.add(Food(R.drawable.pizza,"Pizza"))
        foodList.add(Food(R.drawable.superghet,"Superghett"))
        foodList.add(Food(R.drawable.sandwitch,"SandWich"))
        foodList.add(Food(R.drawable.rollex,"Rollex"))
        foodList.add(Food(R.drawable.chapati,"Chapatti"))


        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter

        foodAdapter.onItemClick = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("food",it)
            startActivity(intent)
        }


    }
}