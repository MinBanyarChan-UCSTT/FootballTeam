package com.mibanyarchan.footballteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mibanyarchan.footballteam.adapter.TeamDetails
import com.mibanyarchan.footballteam.api.FTeam
import com.mibanyarchan.footballteam.model.TeamItem
import com.mibanyarchan.footballteam.repository.TeamApiResponse
import com.mibanyarchan.footballteam.serviceGenerator.TeamService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView =findViewById(R.id.rev_teamList)


        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val request=TeamService.buildService(FTeam::class.java)
        val call:Call<TeamApiResponse> = request.getTeamDetail()
       // val call: Call<TeamApiResponse> = request.getTeamDetail("Barcelona")
        call.enqueue(object :Callback<TeamApiResponse>{
            override fun onResponse(call: Call<TeamApiResponse>,response: Response<TeamApiResponse>
            ) {
                if(response!=null) {
                    recyclerView.adapter=
                        response.body()?.teams?.let { TeamDetails(it as ArrayList<TeamItem>,applicationContext) }
                     // Toast.makeText(applicationContext, response.body().toString(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<TeamApiResponse>, t: Throwable) {
                TODO("Not yet implemented")
                println("Not sucess")
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        val menuItem=menu!!.findItem(R.id.search)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}