package com.tossdesu.bankcardinfo.presentation

import com.tossdesu.bankcardinfo.domain.entity.CardBin
import com.tossdesu.bankcardinfo.domain.entity.CardInfo
import com.tossdesu.bankcardinfo.presentation.MainActivityUiState.*

/**
 * Sealed class for observe MainActivity UI state
 * [CardData] - successful response, receive info about cardInfo as [CardInfo] object
 * [BinSearchHistoryData] - response, receive livedata list of [CardBin] objects
 * [Loading] - showing progress bar, while loading data
 * [FatalError] - showing alert dialog for HttpExceptions(except 404, 400) and Unknown Exceptions
 * [NoConnectionError] - IOException (No Internet connection), showing Snackbar with reload button
 * [ValidateError] - business logic errors, showing Snackbar without any buttons
 * [NothingFoundNotification] - 404, 400 HttpException handling, nothing was found
 */
sealed class MainActivityUiState {
    data class CardData(val cardInfo: CardInfo) : MainActivityUiState()
    data class BinSearchHistoryData(val cardBins: List<CardBin>) : MainActivityUiState()
    object Loading : MainActivityUiState()
    data class FatalError(val title: String, val message: String) : MainActivityUiState()
    object NoConnectionError : MainActivityUiState()
    object ValidateError : MainActivityUiState()
    object NothingFoundNotification : MainActivityUiState()
}