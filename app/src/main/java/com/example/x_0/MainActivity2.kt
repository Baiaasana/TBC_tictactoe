package com.example.x_0

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.x_0.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMain2Binding

    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    private lateinit var button9 : Button

    private var roundCount : Int = 0

    private lateinit var winner1Number : TextView
    private lateinit var winner2Number : TextView


    var firstPlayer = mutableListOf<Int>()
    var secondPlayer = mutableListOf<Int>()
    var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        button1 = binding.button1
        button2 = binding.button2
        button3 = binding.button3
        button4 = binding.button4
        button5 = binding.button5
        button6 = binding.button6
        button7 = binding.button7
        button8 = binding.button8
        button9 = binding.button9

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        winner1Number = binding.winner1times
        winner2Number = binding.winner2times
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {

        if (activePlayer == 1) {
            clickedView.text = "x"
            clickedView.setBackgroundColor(Color.GREEN)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
            roundCount++
        } else {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.YELLOW)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
            roundCount++
        }

        check(clickedView)
    }

    fun check(clickedView: Button) {

        var winner = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winner = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winner = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winner = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winner = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winner = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winner = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winner = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winner = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winner = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winner = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winner = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winner = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winner = 2
        }
        if (winner == 1){
            Toast.makeText(this, "first player won", Toast.LENGTH_SHORT).show()
            winner1Number.text = (winner1Number.text.toString().toInt() + 1).toString()
            gameInactive()

        }
        else if (winner ==2) {
            Toast.makeText(this, "second player won", Toast.LENGTH_SHORT).show()
            winner2Number.text = (winner2Number.text.toString().toInt() + 1).toString()
            gameInactive()
        }
        if ((roundCount.mod(9) == 0) && winner != 1 && winner != 2) {
            draw()
        }

    }

    fun reset(reset:View){

        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer = 1
        if (roundCount<10){
                roundCount = 0
        }

        gameActive()

        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""

        button1.setBackgroundColor(Color.WHITE)
        button2.setBackgroundColor(Color.WHITE)
        button3.setBackgroundColor(Color.WHITE)
        button4.setBackgroundColor(Color.WHITE)
        button5.setBackgroundColor(Color.WHITE)
        button6.setBackgroundColor(Color.WHITE)
        button7.setBackgroundColor(Color.WHITE)
        button8.setBackgroundColor(Color.WHITE)
        button9.setBackgroundColor(Color.WHITE)
    }

    fun gameActive(){
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
    }
    fun gameInactive(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }

    private fun draw(){
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button){
            var buttonNumber = 0

            when (clickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if(buttonNumber != 0){
                playGame(clickedView, buttonNumber)
            }
        }
    }
}