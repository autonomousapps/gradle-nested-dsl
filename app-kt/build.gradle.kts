plugins {
  id("mutual.aid.oppression-plugin")
  id("mutual.aid.people-plugin")
}

application {
  mainClass.set("mutual.aid.AppKt")
}

theState {
  theDeepState {
    theDeepestState {
      undermine("the will of the people")
    }
  }
}

thePeople {
  problems {
    create("climateChange") {
      description("There is no question of cost, because the cost of doing nothing is everything.")
      solutions {
        create("cleanEnergy") {
          description("We cannot burn any more fossil energy")
          action("Replace all fossil sources with clean solutions like wind, solar, and geothermal")
          rank(1)
        }
        create("massTransit") {
          description("Single-occupant vehicles are a major source of carbon pollution")
          action("Increase density in urban environments and build free public transit for all")
          rank(2)
        }
        create("stopEatingAnimals") {
          description("Animal agriculture is one of the top contributors to carbon pollution")
          action("Most people can thrive on a plant-based diet and do not need animal protein, and could make such a choice with immediate effect")
          rank(3)
        }
        create("antiRacism") {
          description("People of Western European descent ('white people') have been the primary beneficiaries of burning fossil carbon")
          action("White people should should bear the responsibility of paying for climate change mitigation")
          rank(4)
        }
        create("seizeGlobalCapital") {
          description("The costs of climate change are inequitably distributed")
          action("The costs of climate change mitigation should be born primarily by the wealthiest")
          rank(5)
        }
        create("lastResort") {
          description("If the rich and the powerful refuse to get out of the way of legislative reforms of the system killing us all, there is, unfortunately, always a last resort")
          action("It starts with 'g' and rhymes with 'poutine'")
          rank(6)
        }
      }
    }
  }
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
}
