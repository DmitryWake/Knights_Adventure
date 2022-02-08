package com.wake.knightsadventure.data.controller.fight

import com.wake.knightsadventure.data.model.ability.BaseAbilityModel

interface FightControllerInterface {
    fun onStart()
    fun onNext(abilityList: List<BaseAbilityModel>)
    fun onStop()
}