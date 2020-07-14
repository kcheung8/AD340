package android.example.ad340

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class ForecastRepository {

    private val _weeklyForecast = MutableLiveData<List<DailyForecast>>()
    val weeklyForecast :LiveData<List<DailyForecast>> = _weeklyForecast

    fun loadForecast(zipcode: String){
        val randomValues = List(7){ Random.nextFloat().rem(100) * 100 }
        val forecastItems = randomValues.map{temp->
            DailyForecast(temp, getTempDescription(temp))
        }
        _weeklyForecast.setValue(forecastItems)
    }

    private fun getTempDescription(temp:Float): String{
        return when(temp){
            in Float.MIN_VALUE.rangeTo(0f) -> "Doesnt make sense"
            in 0f.rangeTo(40f) ->"Extremetly Cold"
            in 40f.rangeTo(70f) -> "Okay"
            else -> "Its hot. AC on please"
        }
    }

}