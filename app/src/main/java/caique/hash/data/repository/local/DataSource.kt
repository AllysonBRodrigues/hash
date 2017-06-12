package caique.hash.data.repository.local

import caique.hash.domain.boundary.LocalRepository
import caique.hash.domain.model.History
import com.google.gson.Gson
import com.jgabrielfreitas.datacontroller.DataController
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Kanda on 10/06/2017.
 */
class DataSource @Inject constructor(val dataController: DataController, val gson: Gson) : LocalRepository {
    override fun getHistory(): Observable<History> {
        return Observable.create({
            val historyString: String? = dataController.readStringData("history")
            val history: History
            if (historyString != null) {
                history = gson.fromJson(historyString, History::class.java)
            } else {
                history = History(0, 0, 0)
            }
            it.onNext(history)
        })
    }


    override fun setHistory() {

    }

    override fun savePlayed() {

    }

    override fun getLastMatch() {

    }

}