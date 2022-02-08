package com.wake.knightsadventure.data.controller.ability

import com.wake.knightsadventure.data.model.ability.AbilityControllerModel
import com.wake.knightsadventure.data.model.ability.BlockAbility
import com.wake.knightsadventure.data.model.ability.DamageAbility
import com.wake.knightsadventure.data.model.ability.HealAbility

class AbilityController : AbilityControllerInterface {

    override fun process(data: AbilityControllerModel): AbilityControllerModel {
        if (data.playerData.second?.id != data.enemyData.second?.id) {
            if (data.playerData.second is BlockAbility &&
                (data.playerData.second as BlockAbility).blockList.contains(data.enemyData.second?.id)
            ) {
                data.enemyData.first.abilityList.remove(data.enemyData.second)
            } else if (data.enemyData.second is BlockAbility &&
                (data.enemyData.second as BlockAbility).blockList.contains(data.playerData.second?.id)
            ) {
                data.playerData.first.abilityList.remove(data.playerData.second)
            } else {
                when (data.playerData.second) {
                    is DamageAbility -> {
                        data.enemyData.first.healthPoints -= (data.playerData.second as DamageAbility).damage
                    }
                    is HealAbility -> {
                        data.playerData.first.healthPoints += (data.playerData.second as HealAbility).heal
                    }
                }

                when (data.enemyData.second) {
                    is DamageAbility -> {
                        data.playerData.first.healthPoints -= (data.enemyData.second as DamageAbility).damage
                    }
                    is HealAbility -> {
                        data.enemyData.first.healthPoints += (data.enemyData.second as HealAbility).heal
                    }
                }
            }
        }

        return data
    }
}