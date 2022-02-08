package com.wake.knightsadventure.data.controller.ability

import com.wake.knightsadventure.data.model.ability.BaseAbilityModel
import com.wake.knightsadventure.data.model.PlayerModel
import com.wake.knightsadventure.data.model.ability.AbilityControllerModel

interface AbilityControllerInterface {
    fun process(data: AbilityControllerModel): AbilityControllerModel
}