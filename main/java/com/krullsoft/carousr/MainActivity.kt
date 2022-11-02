package com.krullsoft.carousr

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

        val btnRoll: ImageButton = findViewById(R.id.btn_Roll)
        val btnInfo: ImageButton = findViewById(R.id.btn_Info)


        btnRoll.setOnClickListener { onButtonPress() }
        btnInfo.setOnClickListener {
            val intent = Intent(this, Info::class.java)
            startActivity(intent)
        }

        txt_carouse_event.setMovementMethod(ScrollingMovementMethod())

    }

    private fun rollDice(numSides:Int):Int {
        val dice = Dice(numSides)
        return dice.roll()

    }

    private fun carousingEvent(diceRoll:Int):String {
        val races = listRaces()
        val drugs = listDrugs()
        val trinkets = listTrinkets()
        val professions = listProfessions()
        val wounds = listWounds()
        val locations = listLocations()
        val shittyItems = listShittyItems()
        val gods = listGods()
        val bodyParts = listBodyParts()
        val games = listGames()
        val pets = listPets()
        val nicknames = listNicknames()
        val animals = listAnimals()
        val myths = listMyths()
        val guilds = listGuilds()
        val hotornot = listHotOrNots()
        val mounts = listMounts()
        val weapons = listWeapons()
        val weaponMaterials = listWeaponMaterials()
        val weaponMods = listWeaponMods()

        return when (diceRoll) {
            1 -> ("You awaken to the sound of dripping water, your head pounding, on the cold, hard cell floor of the local constabulary. A rat nibbles at your boot. \n \nYour ankles ache, and as you try to move you hear the clank of chains, realise you are shackled to the wall. \n \nIt appears you have been apprehended for your drunken and disorderly conduct. You gain one level of exhaustion.")
            2 -> ("You awaken, face down, beaten and bruised in the alley behind the local drinking establishment. Two small children prod you with a stick. \"Is he dead?\" they chatter to themselves. They are terrified as you rise to your knees and vomit at your feet. \n \nYour coinpurse appears to have been stolen, and you have a pounding headache. Gain one level of exhaustion. \n \n[Upon enquiry the children can describe the thief to you, a ${randomRace(races)} who carries stolen goods to the value of ${rollDice(180) +20} gold pieces in addition to your coinpurse.]")
            3 -> ("You awaken, face down, in the alley behind the local drinking establishment. You rise to your knees and immediately vomit on the floor. \n \nYou have a pounding headache and one level of exhaustion.")
            4 -> ("You overhear conversation regarding the neighbouring village of Overton, who's lord is a supposedly a terrifying necromancer of untold power. \n \nThe townsfolk are terrified of their secular neighbours, and believe them to be cursed. \n \n[Upon investigation, the lord of Overton was once a wizards apprentice, and uses his skill in necromancy to put the dead into servitude. \n \nThey till land, lay bricks and other menial tasks, allowing the townsfolk to live in luxury; willingly donating their bodies to the cause after they die.\n \nOpening trade routes between Overton and the surrounding villages would be quite prosperous, though it could raise some moral arguments.]")
            5 -> ("You befriend a group of local builders, and you swap stories about your life of adventuring and their hard days of labour. \n \nGriswald Dunn is midway through telling you a story about his son Fenthick learning to use a wood-turning lathe when a peasant bursts through the saloon doors clutching a wound on his neck, which is pouring with blood. White as a sheet and stricken with terror, he screams \"Z..Z….ZOMBIES!\" before collapsing to the ground.\n \n[${rollDice(6)+rollDice(6)} zombies are attacking the tavern. The builders have uncovered an ancient tomb by mistake and released a long-forgotten evil.]")
            6 -> ("While travelling home from the tavern, you see a local guardsman shake down a young ${randomRace(races)}, forcing them to pay a 'highway tax'. \n \nIt's the first time you've heard of such a tax, and something very suspicious seems afoot... though you might be too intoxicated to resolve the situation easily.")
            7 -> ("While at the bar you are approached by a mysterious tiefling, his horns protruding from his hooded robes.\n\nHe pulls apart his cloak with his forked tail and reveals an murky vial containing ${randomDrug(drugs)}, a potent narcotic. \n \n \"See anything you like, stranger? Yours for only ${rollDice(20)+5} pieces of gold, friend. I promise you won't regret it.\"" )
            8 -> ("While at the bar you are approached by a mysterious tiefling, her horns protruding from her hooded robes.\n\nShe pulls apart her cloak with her forked tail and reveals some generic adventuring items, amongst which is ${randomTrinket(trinkets)}. \n \n \"See anything you like, stranger? Yours for only ${rollDice(10)+5} pieces of gold, friend. I promise you won't regret it.\"")
            9 -> ("While at the bar you strike up conversation with an elderly ${randomRace(races)} who was once a well-travelled adventurer. \n \nHe regales you with tales of his lifes work, where alongside a rag-tag bunch of misfits (reminiscent of your own travelling companions), he set out to track down and slay a demonic knight, who he defeated in a duel atop a spire at the knights castle during a fierce thunderstorm. \n \nHe's looking to go on one last real adventure.")
            10 -> ("While at the bar you strike up conversation with a local ${randomRace(races)}, who unknowingly bears an item of some importance, which they accidentally leave behind when they go to the bar.\n\nUpon inspection, the item appears to be ${randomTrinket(trinkets)}.")
            11 -> ("While drinking with a group of locals, your drink is knocked over by another patron, a ${randomRace(races)} druid.\n \nThe druid has a crescent moon tattooed on his face, and he arguing with a ${randomRace(races)} hunter wearing heavy furs and a hat made from a raccoons pelt. \n \nThe wise, stubborn druid condemns the boisterous ranger for what he feels is his right to hunt game in a nearby forest; drunken emotions run high, and an argument ensues.")
            12 -> ("You collapse wearily into your bed after an evening of heavy drinking. In your dreams, a heavy mist rolls in, and you see an ancient and forgotten forest. \n \nAs you stumble through the unforgiving brushland, you pull back some thick brambles and reach the epicentre - a mighty oak tree, hundreds of feet high in an idyllic grove. \n \nThe branches of the tree stretch out for a great distance, and you can see birds roosting and a squirrel carrying an acorn back to his nest. \n \nYou kneel at the foot of the tree and wash your face in a glistening pool of cool water. As you open your eyes, you see the gnarled bark of the tree creak and shift into a smile, and the gargantuan tree speaks to you in a deep, pensive tone.\n \n[If the character has respected nature, they are rewarded with some useful information about their quest, otherwise they are condemned and encouraged to change their ways]")
            13 -> ("While at the bar you overhear rumours of a dragons lair in some foothills nearby, and that sheep and cattle have recently gone missing. \n \nA local ${randomRace(races)} peasant draws a roughly-hewn iron sword from a leather scabbard and proudly declares he will slay the dragon in return for a young maidens hand. \n \nHe is clearly inexperienced with combat and is sure to be heading to his doom. (The 'dragon' is actually a basilisk, unknown to the adventurers.)")
            14 -> ("While at the bar you learn from an anxious ${randomRace(races)}, an apprentice to a local ${randomProfession(professions)}, who is on his deathbed. \n \nThe apprentice is vastly under-skilled and needs all the help he can get to keep things up and running.")
            15 -> ("Two ${randomRace(races)} nobles at a nearby table have a dispute in their native tongue that grows louder and louder, until the whole tavern is watching them bicker.\n\nOne picks up his glove from the table and slaps the other with it, and they head outside, hands on their rapiers.\n\n[If uninterrupted, they will duel each other to the death.]")
            16 -> ("During the evenings festivities, two men enter the tavern. Each wears a nasal helmet and heavy chainmail, and have thick moustaches.\n\nAround each of their necks is a brass badge shaped like a shield, emblazoned with three snowflakes, which you recognise as the emblem of Neverwinter.\n \nThey approach each table, one after the other, to enquire about the whereabouts of a familiar NPC.\n\n[Questions they may ask are:\n\n- \"When and where did you last see X?\" or\n\n- \"What is your relation to X?\"\n\nThough the players do not have to tell the truth, anything they say that doesn't add up might warrant further investigation.\n\nAfter questioning you, they pin up a wanted poster or missing persons poster and leave.]")
            17 -> ("During the evenings festivities, you overhear the locals complaining about a colony of lizardfolk who have set up camp on the edge of town.\n\nThe townsfolk are cautious of the lizardfolk, as they're rumoured to be aggressive savages who eat anything and anyone they kill.\n \n(Upon investigating, the lizardfolk are relatively amicable, and have been displaced by the construction of a network of dams that have cut off access to water in their swamp and caused their crops to die.)")
            18 -> ("The local bartender offers you a selection from his new range of fine beverages brewed by a druid living in a nearby woodland:\n\n- a delicious dry cider pressed from a variety of apple named 'Somerset Redstreak'. \n- a sweet gin made from sloes named 'Blackthorns Brew'. \n- an exceptionally potent, lime green absinthe in a clear bottle labelled 'Witches Wormwood'. \n\nThe bottle has a live glowworm wriggling around at the bottom, which the barman assures you \"just adds to the experience.\"")
            19 -> ("You awaken with a horrible headache in the wilderness outside of town. You are inside a poorly constructed wooden cage fashioned from wood and bone.\n\nTwo enormous barbarians with fur clothing rest their weary bodies by a fire, one gnawing on what appears to be a human leg.")
            20 -> ("You awaken with a horrible headache and ${randomWound(wounds)} in ${randomLocation(locations)} with no memory of how you got there.")
            21 -> ("While dancing on the tavern bar and having the time of your life, all the patrons were looking at you and your incredible moves. \n\nOr so you thought. \n\nIn reality, you were incredibly drunk, and people were laughing at your oafish behaviour.\n\nMake a DC15 dexterity saving throw.\n\nIf you pass, you clumsily slip from the bar and spill your drink on the innkeeper.\n\nIf you fail, you tumble from the bar and fall on a bar stool, taking 2d4 (${rollDice(4)+rollDice(4)}) bludgeoning damage, and resulting in ${randomWound(wounds)}.")
            22 -> ("You wake up in a room at the local tavern cradling ${randomShittyItem(shittyItems)}.\n\nYou can't remember how you got hold of it, but your coinpurse is ${rollDice(75)+10} gold pieces lighter.")
            23 -> ("After having far too much to drink, you are talked into joining a fringe religious sect.\n\nThe cult worships the deity ${randomGod(gods)}.\n\nThis symbol is now tattooed on your ${randomBodyPart(bodyParts)}.")
            24 -> ("After having far too much to drink, you are talked into joining a fringe religious sect.\n\nThe cult worships the deity ${randomGod(gods)}.\n\nEvery ${randomProfession(professions)} in the town greets you with a wink, an unusual handshake and refers to you as 'the chosen one'.\n\nYou know you can count on them for a favour.")
            25 -> ("Another member of the party enters you into ${randomGame(games)} competition as a joke. Make an appropriate skill check determined by your dungeonmaster.\n\nOn an 18 or higher, you win the contest. Your name is added to the wall of fame, granting you free room and board for the week and a ${rollDice(50)+10} gold piece prize!\n\nWith a 15 or higher you come second or third, and are given a drink on the house.\n\nOn a roll of 1 or less you come last in the competition, and are awarded with a wooden spoon.")
            26 -> ("You spend the night drinking with John, a very friendly and popular human druid known locally as 'Old Man Bongleaf'.\n\nJohn is a skilled herbalist and horticulturalist, and smokes a pipe packed with a pungent herb. He carries a gnarled wooden staff and his clothing is obviously hand-made. His voice is raspy and gravelled, with long greying hair and a beard to match.\n\nAfter a few drinks, he asks if you'll take a hessian sack to a herbalist at the next town for a 50gp reward. The sack weighs about five pounds and smells of strong herbs, but doesn't have an opening, so it would have to be torn to be opened.\n\n\"Mum's the word!\", John says, smiling with a cheshire grin, revealing a few gold teeth as he exhales a perfect smoke-ring.\n\n[opening the pack reveals it is filled with an illegal narcotic known as as 'old toby', but the guards in the town are good friends of Johns, and won't search your sack once they see it.]")
            27 -> ("You groggily awaken in your room at the tavern with a pounding headache to ${randomPet(pets)} your head.\n\nYou have absolutely no idea how it got there, but the little collar around it has your name inscribed on it, and your coinpurse is ${rollDice(50)+5} gold pieces lighter.\n\nIt seems very well trained, it's absolutely infatuated with you and it even understands your native language (though cannot necessarily speak it).")
            28 -> ("You dream of walking through the cool night air. Your throat is parched and your body aches, desperate to slake your thirst. Weakly, you stumble to a fountain in the city centre.\n\nAs you kneel down to it, you see that it is not water in the fountain, but warm, fresh blood, steam rising off of it, the moonlight reflected in its surface.\n\nYou lower your head to drink, but cannot open your mouth.\n\nAs you realize in horror that your lips have been sewn shut, a pair of emaciated, bony, pale hands reach out from the pool and draw you under.\n\nYou awaken, screaming.")
            29 -> ("In your dream, you open your eyes to a beautiful blue sky. The sun is bright, but you feel cool, even a bit damp.\n\nYou draw a breath but begin to splutter, as you expel dirt gravel that you've inhaled into your lungs. As you try to draw another, you see a shovelful of soil being emptied directly onto your face.\n\nThe sunlight dwindles as it peeks through the soil that covers your body, the the weight of which presses you down, rendering you unable to move.\n\nYou would scream, but your mouth fills with dirt before you can make a sound.\n\nYou awaken, dripping with sweat and screaming.")
            30 -> ("A warm, gentle breeze causes a tickle on your face, but as you go to brush it off, you find you cannot move your arms.\n\nLooking at your skin, you realize that it has turned to a brittle, green glass. Standing perfectly still, you breathe in shallow gulps of air, knowing that moving would cause your skin to shatter into thousands of pieces.\n\nThe tickle on your face worsens, and you know that you are about to sneeze.\n\nAs your skin shatters, you wake up sweating.")
            31 -> ("You lay on your back, with a blissful feeling of peace swirling through your brain. Your every muscle is relaxed. There is no tension in any part of your body. You feel completely at ease.\n\nAs your vision comes into focus, you notice others standing around you. As a man leans towards you, you recognize the robes of the Necromancer, and you see a glint of light from his scalpel as it begins to cut through your flesh, and you awaken screaming.")
            32 -> ("You dream of a luxious banquet hall, with a banquet spread out before you, fit for a king amongst kings.\n\nYou feast on a particularly delicious honey-roasted pork chop, and its aroma makes you ravenous.\n\nWiping the wine from your lips, it is only as you cut into the last portion of the sumptuous pork that you see the maggots writhing inside.\n\nYou retch, and drop to the floor of the dining hall, coughing blood as the maggots begin eating their way out of your stomach, and you awaken, screaming.")
            33 -> ("In a dream from your childhood you remember playing hiding games with your young friends on a warm summer afternoon. You hide in your parents' barn, sure you will not be found.\n\nSoon, the sweet smell of hay is replaced by a darker, sickly smell. You move deeper into the barn, only to stumble on the rotting corpses of your parents, their throats ripped out.\n\nYou try to scream as your parents rise and pull you into an embrace.")
            34 -> ("In your dream, an old wise-woman treats you for burns on your hands.\n\nAs she applies a thick unguent to your skin, you feel the tingle of magic as the pain begins to subside.\n\nBut as you watch, the flesh of your hands begins to bubble, crack, and split, falling in chunks to the floor of her hut.\n\nAs the wise-woman smiles, you awaken, screaming.")
            35 -> ("In your dream, you see a beautiful young woman holding an infant to her breast.\n\nIt is only as you draw near that you realize that the woman is a desiccated corpse and the child is purple and bloated, dying of plague.\n\nAs mother and child crumble to dust, you awaken, screaming.")
            36 -> ("You dream of long days spent basking in the sunlight of your native lands. You feel the warmth and the heat, and feel your body become refreshed.\n\nThen you awaken in your room, knowing it was but a dream.")
            37 -> ("Drunkenly stumbling into your room, you dream deeply of a walk through a farmers field you frequented in your childhood. The sun shines down on your back as you run your fingertips through the wheat, and birds twitter and chirp.\n\nYou begin climbing the winding road that leads back to your home, and as you cross the brow of the hill, the chirping songbirds change to ravens cawing, the soft ploughed ground to well-trodden mud, and the wheat becomes scorched and trampled.\n\nYou see your hometown ravaged by a ferocious battle, and pass dozens of warriors who are dying the mud, calling for their mothers, missing limbs or cradling their guts.\n\nOn the horizon you see a dozen more warriors emblazoned with the symbol of your home nation locked in combat with a single, lone knight.\n\nThe knight moves with blinding speed, dismembering soldier after soldier without pause. In a wisp of shadow he appears behind the final soldier and removes his head in a single blow.\n\nAs he slowly turns you face you, his eyes burning with a red flame, you see your own face looking back at you, and awaken, screaming.")
            38 -> ("You found a forlorn looking man at the bar, and bought him a glass of whiskey to lighten him up.\n\nYou drink with him for hours, and he regales you with his sad and lonely tale. He tells you his name is Maurice, and he is one of the local nightwatchmen.\n\nHis loving wife was slain by Maurices own jealous brother, and feeling he failed to protect her, he has since abandoned his post and is stricken with grief.\n\nYou turn to the barman to order you both another round, and when as you go to hand Maurice his drink, he's nowhere to be found. You ask the barman where Maurice has gone, and he has a puzzled look on his face and stops polishing his glass.\n\n\"Watchman Maurice? He died years ago... his own brother found him drowned in the well. A sad tale.\"")
            39 -> ("You gently awaken in perfect relaxation in a warm bath. The steamy room smells of fresh roasting casserole, and you have a garlicky taste in your mouth.\n\nOpening your eyes, you find yourself in a rickety shack. Across the room you see a disgusting hag grinding herbs with a mortar and pestle, and realise you're about to be boiled into a delicious broth.\n\nAs she turns to you and begins sprinkling the herbs onto your head, she screams in shock as she realises you're alive.")
            40 -> ("You wake up groggy and confused in the street in the center of town. Your clothes stink of alcohol and sweat.\n\nPassers by hold their noses and look down at you with utter disgust as they pass.\n\nYou now have ${randomWound(wounds)} but with no recollection of how it happened.")
            41 -> ("You wake up groggy and confused in the street in the center of town. Your clothes stink of alcohol and sweat.\n\nYou are barefoot, wearing a wooden plaque around your neck that reads 'The end is nigh!' on the front, and 'Ours is a deserved damnation!' on the back.")
            42 -> ("You wake up groggy and confused in the street in the center of town. Your clothes stink of alcohol and sweat.\n\nBy your feet is ${randomTrinket(trinkets)}.")
            43 -> ("You awaken in a room in the local tavern, groggy and very hungover.\n\nEveryone in the town keeps calling you '${randomNickname(nicknames)}' but you have no idea why.")
            44 -> ("During your night of heavy drinking, you lost a wager on ${randomGame(games)} contest with a ${randomRace(races)} and their friends, and ended up spending ${rollDice(45)+5} gold pieces buying drinks for everyone in the tavern.\n\nFortunately the locals love you for it, and you're the talk of the town!")
            45 -> ("During your night of belligerent drinking, you insulted a travelling conjurer, who polymorphed you into ${randomAnimal(animals)} for one day.\n\nThat'll teach you.\n\nHopefully it'll wear off soon...")
            46 -> ("Waking up in the tavern room with a groggy head, you remember getting drunk with a ${randomRace(races)} who boasted that he was ${randomMyth(myths)}.\n\nYou now possess ${randomTrinket(trinkets)} but have no memory of how you acquired it.\"")
            47 -> ("You spent all night drinking with a dwarven smith, Dûrin Deepfire.\n\nDûrin is a hardy, grizzled old dwarf of lawful neutral alignment with a wiry ginger beard. He wields a huge warhammer and finely crafted suit of armour.\n\nHe's an incredibly talented metalworker, and can forge quality weaponry, armour and tools if he's provided with the materials and a small sum of gold.\n\nThough mostly retired from his life of adventuring, he can be tempted to accompany you for a time once he learns about any riches and plunder that might be available from your quest.")
            48 -> ("You spent all night drinking with an elderly human wizard, Dr. Octavius Mortimore.\n\nDr. Mortimore is a spindly, whizzened old man with a neutral good alignment. He carries a wooden quarterstaff and a large book, but not many other possessions. He wears a hooded black robe and a plague mask, which he explains is filled which scented flowers to mask the smell during his work as a mortician.\n\nAfter prying him away from an argument with a local priest, you became good friends. He told you about his quest to provide free and universal healthcare to the people of Faerûn, and wants to set up a clinic.\n\nIn return for three gold pieces to fill his component pouch, he offers his services as a wizard and doctor for the next day.")
            49 -> ("You spent all night drinking with a barbaric dwarf warrior, named Fergus McLeod.\n\nFergus is a stocky, drunk, rude and aggressive warrior, with a chaotic neutral alignment and a thick scottish accent. He carries a colossal greataxe but not many other possessions. He wears a kilt and sporran, and his bright red hair and beard makes him stand out from the crowd.\n\nAfter prying him away from almost starting a fight with an off-duty town guard, you became good friends.\n\nHe told you about his quest for wealth and women,  grumbles a lot about his ex-wife Muriel, and seems to be itching for a fight.\n\nAfter running out of gold, he offers his services as a warrior for the next day in return for a few drinks and something to eat.")
            50 -> ("You spent all night drinking with a barbaric lizardfolk warrior, named Krull.\n\nKrull is an enormous and aggressive warrior, with a chaotic neutral alignment. He carries a colossal greatsword but not many other possessions.\n\nAfter prying him away from almost starting a fight with a snooty noble, you became good friends.\n\nHe told you about his quest to restore honour to his tribe by finding the members of his family that have been captured and sold into slavery by humans, and to restore his rightful place on the throne as Ratu (chieftain) of clan Blackscale, in the swamps of Sandur.\n\nHaving no concept of gold, he offers his services as a warrior for the next day in return for a few drinks.")
            51 -> ("You spent all night drinking and gambling with a dragonborn priest, named Torin.\n\nTorin is a tall, golden dragonborn with a lawful good alignment. Torin carries a large blue shield emblazoned with a silver dragon and a well-polished longsword with a dragon motif in the hilt.\n\nAfter prying him away from a religious argument with a paladin of Tyr, he told you about his holy quest to spread the word of Bahamut, and to acquire a holy artifact of immeasurable power to restore honour to his temple on the spine of the world.\n\nIf he considers your quest honourable, he offers his services as a holy warrior for the next day.")
            52 -> ("You spent all night drinking and gambling with a missionary of the sun god Pelor, named Rickas Crow.\n\nRickas has a neutral good alignment, wears well-worn chainmail and carries a huge spear and a round shield, similar to that of a hoplite.\n\nAfter prying him away from the liars dice table, he broke down and told you about his gambling addiction, his holy quest to spread the word of Pelor, and his aims to rebuild his now-defunct circle of paladins, the Order of the Burning Sun.\n\nAfter apologising profusely, he offers his services as a holy warrior for the next day in return for helping him confess his sins.")
            53 -> ("You awaken in a room in the local tavern, and remember your night of heavy drinking and gambling was very successful, and you're ${rollDice(6)+rollDice(6)} gold pieces and ${rollDice(10+rollDice(10))} silver pieces richer.\n\nAfter running out of gold, one of your opponents, a mysterious ${randomRace(races)} salesman, gave you a huge egg that is warm to the touch.\n\nIt wiggles around and looks like it might hatch any minute.\n\nThe egg contains a pseudodragon that regards the first person it sees as its mother.")
            54 -> ("You spent all night drinking with the mayor of the town, and accidentally humiliated them publicly.\n\nYou groggily remember dancing on the tavern bar and kicking a drink all over them, and confusing their spouse with a courtesan.\n\nYou know they won't have forgotten it.")
            55 -> ("You spent all night drinking with the mayor of the town, and showed them a great night.\n\nThe wines, beers and spirits flowed with abundance, and you dined like a king.\n\nYou groggily remember dancing on the tavern bar, doing shots from the body of a ${randomRace(races)} courtesan, and you know you can count on the mayor for a favour.")
            56 -> ("You awaken well-rested in a room at the local tavern.\n\nOn the nightstand is a formally stamped letter explaining how in your intoxicated state, you wound up joining a middling local organization, the ${randomGuild(guilds)}.\n\nFortunately they also paid for your room and living expenses for the night.")
            57 -> ("You awaken naked in a pile of straw in the barn of a nearby farmhouse. The air stinks of wet fur. Your equipment is scattered all about the room, and your clothing is in tatters.\n\nA lamb lies disemboweled a few feet away from you, its entrails, blood and viscera all over the floor.\n\nYou wipe warm blood from your mouth, and through the ajar barn door you can see the farmer putting on his boots and getting ready to begin the day.\n\nThen you wake up in the middle of the night, dripping with sweat, in a room at the local tavern, the full moon looking back at you through the window.")
            58 -> ("You awaken in a room of the local tavern in the middle of the night, feeling a little faint and groggy.\n\nFeeling a small pain in your neck, you notice a small speck of blood on your pillow, and two tiny cuts on your neck.\n\nThe curtain in your room flutters in the wind and you realise the window has been left open, and a bright moon peers in through the misty fog.\n\nYou walk to the mirror to don your clothing and equipment, but do a double-take - you have no reflection! Then you awaken dripping with sweat, screaming.")
            59 -> ("You awaken in the honeymoon suite of the local tavern, wearing formal wedding attire.\n\nA fine gold wedding ring sits snugly upon the ring finger of your left hand, and confetti is strewn across the bed.\n\nLaying beside you is your new spouse, similarly dressed in their wedding attire, a ${randomRace(races)}, along with a dozens of empty bottles of wine.\n\nThey are ${randomHotOrNot(hotornot)}.")
            60 -> ("You wake up in a room at the local tavern, a little bruised, and remember brawling with the towns local hero, a ${randomRace(races)}, and thoroughly humiliating them, despite walking away with ${randomWound(wounds)}.\n\nEveryone in the town hates you for it.")
            61 -> ("You wake up in a room at the local tavern, a little bruised, and remember brawling with the towns notorious bully, a ${randomRace(races)}, and thoroughly humiliating them, despite walking away with ${randomWound(wounds)}.\n\nEveryone in the town loves you for it... except the family of the man you brawled.")
            62 -> ("You wake up in a room at the local tavern and remember overhearing a hushed plot by a group of ${randomRace(races)} criminals to steal a priceless artifact from the ruler of the province.\n\nIt seems like there would be a huge fortune to be made if the heist is successful.")
            63 -> ("You wake up in a room at the local tavern and remember overhearing a hushed plot by a group of ${randomRace(races)} criminals to break an infamous convict out of prison before he is hanged, three days from today.\n\nFrom what you've gathered, It seems like the convict would reward their saviour with the location of their vast treasure hoard.")
            64 -> ("You wake up in a room at the local tavern and remember overhearing a hushed plot by a group of ${randomRace(races)} criminals to assassinate an influential ${randomRace(races)} ${randomProfession(professions)} with a price on their head.\n\nThe contract seems to be worth a fortune.")
            65 -> ("You awaken on the silk sheets of a comfortable bed entwined with an exact clone of yourself.\n\nAs you awaken, you see the look of horror in their face as your doppelganger shapeshifts into a cat and leap out of an open window.")
            66 -> ("You awaken in a pile of straw in a barn to a quarterstaff being tapped against your boot.\n\nA tall wizard grumbles at you as he strokes his long grey beard and puffs on his pipe. \"Do you know the road to Mount Glaurimm?\" he asks.\n\nBeside him are four chattering halflings, a grizzled dwarf with a huge axe who bickers with a finely dressed wood elf archer. Nearby, a hooded human ranger who keeps to the shadows, his eyes fixed on you, whilst keeping one hand on his sword.\n\nAnother, broader human carrying a sword, shield and a large white horn beckons the rest of his party to press on. The elderly wizard gives the halflings a nudge, and they all head off down the road.")
            67 -> ("You awaken alone on the silk sheets of a comfortable double bed in an unfamiliar house.\n\nThe air is rich with the scents of cooked meats and you can hear the sizzling of a frying pan coming from downstairs.\n\nA ${randomRace(races)} enters the room in their undergarments, and invites you down for breakfast. They are ${randomHotOrNot(hotornot)}.")
            68 -> ("You awaken on the filthy sheets of an uncomfortable bed in the local budget whorehouse entwined with two aging ${randomRace(races)} courtesans.\n\nYou feel sore.\n\n(Unbeknownst to them, the character has contracted 'cackle fever'. The symptoms become apparent in two days.)")
            69 -> ("You awaken on the silk sheets of a comfortable bed in an upmarket bordello entwined with two beautiful ${randomRace(races)} courtesans.\n\nBesides a little backache, some scratches on your back and a few new bruises, you feel like a million gold pieces.\n\nUntil your next long rest, you gain one single-use luck point as per the 'lucky' feat.")
            70 -> ("You awaken on the silk sheets of a comfortable bed entwined with a ${randomRace(races)}.\n\nAs you awaken, you see the look of horror in their face as they look back at you with an expression of regret.\n\nThey are ${randomHotOrNot(hotornot)}.")
            71 -> ("You awaken on the silk sheets of a comfortable bed entwined with a ${randomRace(races)}.\n\nAs you awaken, they seem eager to hurry you out of the house, and you see them slip their wedding ring back on. They are ${randomHotOrNot(hotornot)}.")
            72 -> ("You awaken on the silk sheets of a comfortable bed entwined with a ${randomRace(races)}.\n\nAs you awaken, they smile at you lovingly.\n\nThey are ${randomHotOrNot(hotornot)}.")
            73 -> ("You awaken on the silk sheets of a comfortable bed in the private chambers of an NPC you previously made friends with, who lays next you in bed, snoring softly.")
            74 -> ("You awaken on the silk sheets of a comfortable bed in the private chambers of an NPC you previously made enemies with, who lays next you in bed, snoring softly.")
            75 -> ("You awaken on the silk sheets of a comfortable bed in the private chambers of an NPC you previously made friends with, whose spouse lays next you in bed.\n\nThey are ${randomHotOrNot(hotornot)}.")
            76 -> ("You awaken on the silk sheets of a comfortable bed in the private chambers of an NPC you previously made enemies with, whose spouse lays next you in bed.\n\nThey are ${randomHotOrNot(hotornot)}.")
            77 -> ("You awaken in the private section of the confession booth at the local temple, and you aren't wearing any clothes, except for a papal mitre.\n\nYou hear the familiar voice of a local NPC, \"Forgive me father, for I have sinned\", as they begin to confess their most private secrets.")
            78 -> ("You awaken in a wooden booth wearing formal holy vestments.\n\nAs you rise to your feet, you realise you are in pulpit of the local temple, and crowds have arrived for service.\n\nThey quieten down as they await your sermon.")
            79 -> ("You wake up in an alley with a sharp pain on your ${randomBodyPart(bodyParts)}.\n\nIt now bears a lifelike tattoo of an NPC you have befriended in the past.")
            80 -> ("You wake up in an alley with a sharp pain on your ${randomBodyPart(bodyParts)}.\n\nIt now bears a lifelike tattoo of an NPC you have made enemies with in the past.")
            81 -> ("You wake up in an alley with a sharp pain on your ${randomBodyPart(bodyParts)}.\n\nIt now bears a lifelike tattoo of another member of the party.")
            82 -> ("You awaken in the drab, ascetic room of a local inn.\n\nYour mouth tastes of blood and you have a couple of new bruises and a fat lip.\n\nBeside you is a small sack containing about ${rollDice(30)+1} gold pieces worth of an illegal narcotic known as '${randomDrug(drugs)}'.")
            83 -> ("You wake up to find yourself seated at a table. You have a quill in one hand and a small cut on the other.\n\nAcross from you sits a well-dressed but sinister man, a man of wealth and taste. In front of you is a contract detailing in extremely complex terms, the exchange of great power for your immortal soul.\n\n(Once the contract is signed or if the character refuses, the man disappears in a cloud of sulfurous smoke.)")
            84 -> ("You awaken in an alchemist’s shop, your brow dripping with sweat. There are a number of empty vials on the floor around you.\n\nEverything that should be green looks purple and food tastes like it’s vibrating. Occasionally, you burp multi-colored bubbles.\n\nYou turn to one of your allies, only for his face to be that of Asmodeus, the demon lord of sin and king of the nine hells.\n\nTerrified, you scream, but in the blink of an eye their face returns to normal.")
            85 -> ("You awaken groggily in a room at the local tavern, your face sticky with some kind of dried sauce.\n\nOn the nightstand beside you sits a half-eaten meal consisting of delicious strips of spiced roasted lamb meat and unleavened bread. In your pocket you find ${rollDice(99)} copper pieces in spare change, though your coinpurse is a gold piece lighter.\n\nEmpty bottles of ale and wine are scattered across the floor. Your stomach rumbles very loudly.")
            86 -> ("You awaken well-rested, in a quaint room at the local tavern.\n\nOn the nightstand is an affectionate note from the ${randomRace(races)} barmaid and a key to her chambers. She is ${randomHotOrNot(hotornot)}.")
            87 -> ("You awaken well-rested in a room at the local tavern.\n\nOn the nightstand is a passive aggressive and very snooty note explaining how in your intoxicated state, you wound up on the bad side of a middling local organization, the ${randomGuild(guilds)}.\n\nYou haven't heard the last of them.")
            88 -> ("You wake up in a temple on a cold stone dolmen.\n\nThe air is heavy with the scent of incense, and several monks are standing over you offering a pauper’s last rites.\n\nThey seem surprised when you start moving.")
            89 -> ("You wake up in a room at the local tavern.\n\nYour lips are sticky and your mouth is covered in a sweet cherry jam, and the bed is covered in crumbs.\n\nYou are ${rollDice(20)+1} gold pieces richer and are cradling a trophy with a giant pie on top.\n\nYou have never felt more sick to your stomach.")
            90 -> ("You wake up in a room at the local tavern cradling three scrolls penned in beautiful handwriting.\n\nThey appear to be divine spell scrolls of 'Zone of Truth', 'Resurrection' and 'Heal'.\n\nOn the bedside table lies the holy book of ${randomGod(gods)}.")
            91 -> ("You wake up in a room at the local tavern cradling three tattered scrolls scrawled in blood.\n\nThey appear to be arcane spell scrolls of 'Animate Dead', 'Speak with Dead' and 'Finger of Death'.\n\nAt the foot of your bed, a white six-pointed star in a circle has been chalked onto the floorboards. A maroon candle sits on each point of the star, melted down to the base.")
            92 -> ("You wake up in a comfortable bed at the local tavern.\n\nDuring the nights jovial festivities, you drunkenly defended a local lord from a cutpurse.\n\nOn the nightstand beside you is a letter thanking you for your service, attached to a promissory note granting you a steed. It is a ${randomMount(mounts)}.\n\nYour new mount can be collected from the nearest stable.")
            93 -> ("You wake up in a comfortable bed at the local tavern.\n\nDuring the nights jovial festivities, you drunkenly defended a local lord from a cutpurse.\n\nOn the nightstand beside you is a letter thanking you for your service, and granting you an indentured slave, a ${randomRace(races)}, who waits immediately outside the door to your room.")
            94 -> ("You wake up in a room at the local tavern cradling ${randomWeaponMaterial(weaponMaterials)} ${randomWeapon(weapons)} ${randomWeaponMod(weaponMods)}.\n\nYou can't remember how you got hold of it, but your clothes are stained in blood. It's owner probably didn't appreciate it coming into your possession...")
            95 -> ("You wake up in a room at the local tavern cradling ${randomWeaponMaterial(weaponMaterials)} ${randomWeapon(weapons)} ${randomWeaponMod(weaponMods)}.\n\nYou can't remember how you got hold of it, but your coinpurse is ${rollDice(100)+10} gold pieces lighter.")
            96 -> ("You wake up in a room at the local tavern cradling ${randomWeaponMaterial(weaponMaterials)} ${randomWeapon(weapons)} ${randomWeaponMod(weaponMods)}.\n\nYou can't remember how you got hold of it, but poker chips are scattered all over the bed.")
            97 -> ("You found yourself in a high stakes game of liar's dice with a few travelling adventurers, and came away with a fairly weighty coinpurse of ${rollDice(150)+50} gold pieces.\n\nBe careful though, your opponent wasn't a gracious loser.")
            98 -> ("As you find yourself deep in your cups, you are loud, boisterous and the whole tavern listens to the yarns you spin of your recent adventures.\n\nYou spin extravagant tales of treasures you have recently found and the massive profits you are due to make.\n\nAs the evening draws late you notice a ${randomRace(races)} whose sinister smile catches your eye as they pass you.\n\nYou are being watched.")
            99 -> ("You gently awaken in your room in the tavern, feeling perfectly relaxed. Wrapped tightly in the thick blanket, you're perfectly warm and in a state of blissful comfort.\n\nYou hop to your feet with a spring in your step, and you just know that today will be a good day.\n\nUntil your next long rest, you gain one single-use luck point as per the 'lucky' feat.")
            100 -> ("Roll again twice, and your dungeonmaster finds some bizarre combination of the two.")

            else -> ("Number is something else. Mysterious. If you can see this message, then I've made a mistake :(")

        }

    }

    fun onButtonPress() {
        val diceRoll :Int = rollDice(100)
        val carousingEvent = carousingEvent(diceRoll)

        val sounds = intArrayOf(R.raw.diceroll01, R.raw.diceroll02, R.raw.diceroll03, R.raw.diceroll04, R.raw.diceroll05, R.raw.diceroll06, R.raw.diceroll07, R.raw.diceroll08, R.raw.diceroll09, R.raw.diceroll10)
        val r = Random()
        val low = 0
        val high = 10
        val rndm = r.nextInt(high - low) + low
        val mediaPlayer: MediaPlayer? = MediaPlayer.create(this, sounds[rndm])
        setText(diceRoll, carousingEvent)
        mediaPlayer?.start()

    }

    fun setText(diceRoll: Int, carousingEvent:String) {
        val resultTextView: TextView = findViewById(R.id.txt_roll_result)
        val eventTextView: TextView = findViewById(R.id.txt_carouse_event)
        resultTextView.text = diceRoll.toString()
        eventTextView.setText(carousingEvent)

    }

    class Dice(
        private val numSides: Int
    ) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    class Race(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listRaceNames(): List<String> {

        return listOf(
            "aarakocra",
            "air genasi",
            "asiimar",
            "barovian human",
            "calishite human",
            "changeling",
            "chondathan human",
            "chultan human",
            "damaran human",
            "dragonborn",
            "dragonborn",
            "dragonborn",
            "dragonborn",
            "drow",
            "dusk elf",
            "dwarf",
            "dwarf",
            "dwarf",
            "dwarf",
            "earth genasi",
            "firbolg",
            "fire genasi",
            "ghost",
            "gnome",
            "gnome",
            "gnome",
            "gnome",
            "goblin",
            "goliath",
            "grung",
            "half-elf",
            "half-elf",
            "half-elf",
            "half-elf",
            "halfling",
            "halfling",
            "halfling",
            "halfling",
            "half-orc",
            "half-orc",
            "half-orc",
            "half-orc",
            "high-elf",
            "high-elf",
            "high-elf",
            "high-elf",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "human",
            "illuskan human",
            "kenku",
            "lizardfolk",
            "mulan human",
            "orc",
            "rakshasa",
            "rashemi human",
            "shou human",
            "tabaxi",
            "tethyrian human",
            "tiefling",
            "tiefling",
            "tiefling",
            "tiefling",
            "turami human",
            "water genasi",
            "wood-elf",
            "wood-elf",
            "wood-elf",
            "yuan-ti pureblood"


        )

    }

    fun listRaces(): List<Race> {
        val raceNames = listRaceNames()
        val races = raceNames.map { raceName ->
            Race(raceName)
        }
        return races
    }

    fun randomRace(races:List<Race>): Race {
        return races.random()

    }

    class Drug(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listDrugNames(): List<String> {

        return listOf(
            "moon dust",
            "shinewater",
            "skripka",
            "zirpal",
            "burundanga",
            "milk of the poppy",
            "wyvern poison",
            "serpent venom",
            "truth serum",
            "torpor",
            "devilweed",
            "fey mushrooms",
            "liquid rage",
            "widows whisper",
            "toads kiss",
            "sirens song",
            "longbottom leaf",
            "old toby",
            "ground unicorn horn",
            "skist sap",
            "pondsmoke"

        )

    }

    fun listDrugs(): List<Drug> {
        val drugNames = listDrugNames()
        val drugs = drugNames.map { drugName ->
            Drug(drugName)
        }
        return drugs
    }

    fun randomDrug(drugs:List<Drug>): Drug {
        return drugs.random()

    }
    class Trinket(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listTrinketNames(): List<String> {

        return listOf(
            "an ornate key carved from pure shadow",
            "a bone shortsword with a +1 magic bonus and glows with 10ft of dim blue light when an orc, goblin or undead creature is nearby",
            "a flawless diamond (a DC20 investigation check reveals it to be a well-polished fake)",
            "a flawless diamond (worth ${rollDice(150)+150})",
            "a small leather pouch of knucklebones",
            "a small leather pouch of knucklebones that cause loyal skeletons to claw their way from the ground when they are thrown on soil",
            "a tiny steel sword bent into the shape of a ring",
            "a small bronze cage with tiny shackles and chains, inscribed with the name of a demon",
            "a pewter ring set with obsidian, which was supposedly buried with a legendary necromancer long ago",
            "a pewter candlestick crafted in the form of a tower",
            "an ancient tome on draconic lore and mythology",
            "a seashell carved with a crude map of a mythical sunken city",
            "a brass oil lamp engraved with a map of the City of Brass",
            "a white rose petal entombed in quartz",
            "a working wooden miniature of a trebuchet",
            "a small coinpurse crafted from the chainmail of a legendary warrior",
            "a map of Faerun that pinpoints the users location with a big red arrow",
            "a chess piece carved from diamond, worth ${rollDice(150)+150} gold pieces",
            "a quill pen crafted from the feather of a pegasus",
            "a steel mirror in which the living appear as undead, and the dead and undead appear as living",
            "a pair of spectacles that grant darkvision to 120ft",
            "a four-sided die which speaks the result when rolled",
            "a six-sided die which speaks the result when rolled",
            "an eight-sided die which speaks the result when rolled",
            "a ten-sided die which speaks the result when rolled",
            "a twelve-sided die which speaks the result when rolled",
            "a twenty-sided die which speaks the result when rolled",
            "a hundred-sided die which speaks the result when rolled",
            "a full set of polyhedral die which speak the result when rolled",
            "a doll that bears an uncanny likeness of yourself",
            "a mummified goblin hand",
            "a piece of crystal that faintly glows in the moonlight",
            "a gold coin minted in an unknown land",
            "a diary written in a language you don’t know",
            "a brass ring that never tarnishes",
            "an old chess piece made from glass",
            "a pair of knucklebone dice, each with a skull symbol on the side that would normally show six pips",
            "a small idol depicting a nightmarish creature that gives you unsettling dreams when you sleep near it",
            "a rope necklace from which dangles four mummified elf fingers",
            "the deed for a parcel of land in a realm unknown to you",
            "a 1-ounce block of adamantium",
            "a small cloth doll skewered with needles",
            "a tooth from an unknown beast",
            "an enormous scale, perhaps from a dragon",
            "a bright green feather",
            "an old divination card bearing your likeness",
            "a glass orb filled with moving smoke",
            "a 1-pound egg with a bright red shell",
            "a pipe that blows bubbles",
            "a glass jar containing a weird bit of flesh floating in pickling fluid",
            "a tiny gnome-crafted music box that plays a song you dimly remember from your childhood",
            "a small wooden statuette of a smug halfling",
            "a brass orb etched with strange runes",
            "a multi-coloured stone disk",
            "a tiny silver icon of a raven",
            "a bag containing forty-seven humanoid teeth, one of which is rotten",
            "a shard of obsidian that always feels warm to the touch",
            "a dragon's bony talon hanging from a plain leather necklace",
            "a pair of old socks",
            "a blank book whose pages refuse to hold ink, chalk, graphite, or any other substance for marking",
            "a silver badge in the shape of a five-pointed star",
            "a knife that belonged to a relative",
            "a glass vial filled with nail clippings",
            "a rectangular metal device with two tiny metal cups on one end that throws sparks when wet",
            "a white, sequined glove sized for a human",
            "a vest with one hundred tiny pockets",
            "a small, weightless stone block",
            "a tiny sketch portrait of a goblin",
            "an empty glass vial that smells of perfume when opened",
            "a gemstone that looks like a lump of coal when examined by anyone but you",
            "a scrap of cloth from an old banner",
            "a rank insignia from a lost legionnaire",
            "a tiny silver bell without a clapper",
            "a mechanical canary inside a gnomish lamp",
            "a tiny chest carved to look like it has numerous feet on the bottom",
            "a dead sprite inside a clear glass bottle",
            "a metal can that has no opening but sounds as if it is filled with liquid, sand, spiders, or broken glass (your choice)",
            "a glass orb filled with water, in which swims a clockwork goldfish",
            "a silver spoon with an m engraved on the handle",
            "a whistle made from gold-coloured wood",
            "a dead scarab beetle the size of your hand",
            "two toy soldiers, one with a missing head",
            "a small box filled with different-sized buttons",
            "a candle that can’t be lit",
            "a tiny cage with no door",
            "an old key",
            "an indecipherable treasure map",
            "a hilt from a broken sword",
            "a rabbit’s foot",
            "a glass eye",
            "a cameo carved in the likeness of a hideous person",
            "a silver skull the size of a coin",
            "an alabaster mask",
            "a pyramid of sticky black incense that smells very bad",
            "a nightcap that, when worn, gives you pleasant dreams",
            "a single caltrop made from bone",
            "a gold monocle frame without the lens",
            "a 1-inch cube, each side painted a different colour",
            "a crystal knob from a door",
            "a small packet filled with pink dust",
            "the sheet music of a beautiful song, written as musical notes on two pieces of parchment",
            "a silver teardrop earring made from a real teardrop",
            "the shell of an egg painted with scenes of human misery in disturbing detail",
            "a fan that, when unfolded, shows a sleeping cat",
            "a set of bone pipes",
            "a four-leaf clover pressed inside a book discussing manners and etiquette",
            "a sheet of parchment upon which is drawn a complex mechanical contraption",
            "an ornate scabbard that fits no blade you have found so far",
            "an invitation to a party where a murder happened",
            "a bronze pentacle with an etching of a rat's head in its center",
            "a purple handkerchief embroidered with the name of a powerful archmage",
            "a floorplan for a temple, castle, or some other structure",
            "a bit of folded cloth that, when unfolded, turns into a stylish cap",
            "a receipt of deposit at a bank in a far-flung city",
            "a diary with seven missing pages",
            "an empty silver snuffbox bearing an inscription on the surface that says “dreams”",
            "an iron holy symbol devoted to an unknown god",
            "a book that tells the story of a legendary hero's rise and fall, with the last chapter missing",
            "a vial of dragon blood",
            "an ancient arrow of elven design",
            "a needle that never bends",
            "an ornate brooch of dwarven design",
            "an empty wine bottle bearing a pretty label that says, “the wizard of wines winery, red dragon crush”",
            "a mosaic tile with a multicoloured, glazed surface",
            "a petrified mouse",
            "a black pirate flag adorned with a dragon's skull and crossbones",
            "a tiny mechanical crab or spider that moves about when it’s not being observed",
            "a glass jar containing lard with a label that reads, “griffon grease”",
            "a wooden box with a ceramic bottom that holds a living worm with a head on each end of its body",
            "a metal urn containing the ashes of a hero",
            "a picture you drew as a child of your imaginary friend",
            "a lock that only opens when blood is dripped in its keyhole",
            "a pile of clothes stolen from a scarecrow",
            "a spinning top carved with four faces: happy, sad, wrathful, and dead",
            "the necklace of a sibling who died on the day you were born",
            "a wig from someone executed by beheading",
            "the unopened letter to you from your dying father",
            "a pocket watch that runs backward for an hour every midnight",
            "a winter coat stolen from a dying soldier",
            "a bottle of invisible ink that can only be read at sunset",
            "a wineskin that refills when interred with a dead person for a night",
            "a set of silverware used by a king for his last meal",
            "a spyglass that always shows the world suffering a terrible storm",
            "a cameo with the profile’s face scratched away",
            "a lantern with a black candle that never runs out and that burns with green flame",
            "a teacup from a child’s tea set, stained with blood",
            "a little black book that records your dreams, and yours alone, when you sleep",
            "a necklace formed of the interlinked holy symbols of a dozen deities",
            "a hangman’s noose that feels heavier than it should",
            "a birdcage into which small birds fly but once inside never eat or leave",
            "a lepidopterist’s box filled dead moths with skull-like patterns on their wings",
            "a jar of pickled ghouls’ tongues",
            "the wooden hand of a notorious pirate",
            "a urn with the ashes of a dead relative",
            "a hand mirror backed with a bronze depiction of a medusa",
            "pallid leather gloves crafted with ivory fingernails",
            "dice made from the knuckles of a notorious charlatan",
            "a ring of keys for forgotten locks",
            "nails from the coffin of a murderer",
            "a key to your family crypt",
            "an bouquet of funerary flowers that always looks and smells fresh",
            "a switch used to discipline you as a child",
            "a music box that plays by itself whenever someone holding it dances",
            "a walking cane with an iron ferule that strikes sparks on stone",
            "a flag from a ship lost at sea",
            "porcelain doll’s head that always seems to be looking at you",
            "a wolf’s head wrought in silver that is also a whistle",
            "a small mirror that shows a much older version of the viewer",
            "a small, worn book of children’s nursery rhymes",
            "a mummified raven claw",
            "a broken pendent of a silver dragon that’s always cold to the touch",
            "a small locked box that quietly hums a lovely melody at night but you always forget it in the morning",
            "an inkwell that makes one a little nauseous when staring at it",
            "an old little doll made from a dark, dense wood and missing a hand and a foot",
            "a black executioner’s hood",
            "a pouch made of flesh, with a sinew drawstring",
            "a tiny spool of black thread that never runs out",
            "a tiny clockwork figurine of a dancer that’s missing a gear and doesn’t work",
            "a black wooden pipe that creates puffs of smoke that look like skulls",
            "a vial of perfume, the scent of which only certain creatures can detect",
            "a paper fan that won't produce a breeze no matter how hard it's waved",
            "a petrified potato that resembles someone important to you",
            "a glass cup that can only be filled half way no matter how much liquid is pored into it",
            "a mirror that only shows the back of your head",
            "a small glass bird that when set down near water dips its head in as if to get a drink",
            "a lady's coin purse containing two sharp fangs",
            "a small sea conch with the words \"from the beginning\" painted on the lip",
            "a frost-covered silver locket that's frozen shut",
            "a seal which imprints a mysterious, unknown coat of arms into hard rock",
            "a small wooden doll that when held brings back fond memories",
            "a small hand mirror which only reflects inanimate objects",
            "a glass eyeball that looks about of its own accordance, and can roll around",
            "a glass orb that replicates yesterday's weather inside itself",
            "a drinking cup, that randomly fills with fresh or salt water refilling once emptied",
            "a deep blue piece of flint, that when struck with steel produces not a spark but a drop of water",
            "a conch shell which is always damp and constantly drips saltwater",
            "a charred, half-melted pewter clasp that glows as if smoldering but releases no heat",
            "a clockwork finch that flaps its wings in the presence of a breeze",
            "a unbreakable sealed jar of glowing water that hums when shaken",
            "a small, finely polished geode whose crystals slowly fade between every colour of the spectrum",
            "a rough stone eye pulled from a petrified creature",
            "a stone smoking pipe that never needs lighting",
            "a small whistle, that when blown, whispers a name of a person or place unknown to you, instead of the whistle sound",
            "a fist sized rock that beats like a heart",
            "a pair of bronze scissors in the shape of a pair of leaping dolphins",
            "a bronze oil lamp which is rumored to have once held a genie",
            "a single gauntlet inscribed with a fire motif and an unfamiliar name in primordial",
            "a one-eyed little fish inside a spherical vial, much bigger than the vial's neck, with a cunning grin",
            "the tiny skull of a rabbit that whispers scathing insults when nobody is looking",
            "a rag doll in the likeness of an owlbear",
            "the desiccated body of a small eight-legged black lizard",
            "a small toy boat made with a walnut shell, toothpick, and piece of cloth",
            "a small pocket mirror that slowly fogs over while held",
            "wind chimes that glow when the wind blows",
            "a small, clay square with an unknown rune etched into one side",
            "a tea kettle that heats itself when filled with water",
            "an old scratched monocle which shows an underwater landscape whenever someone looks through it",
            "a rose carved from coral",
            "a set of dice with elemental symbols and primordial runes instead of pips or numbers",
            "an amulet filled with liquid that churns, freezes, or boils to match its wearer's mood",
            "a small silver bell that makes a sound like quiet, distant thunder when it's struck",
            "a small vial of black sand that glows slightly in the moonlight",
            "a small whale tooth with etched with an image of waves crashing upon a beach",
            "an hourglass in which the sands pour upward instead of downward",
            "a glass pendant with a hole in the center that a mild breeze always blows out of",
            "a soft feather that falls like a stone when dropped",
            "a large transparent gem that, when gripped tightly, whispers in abyssal",
            "a small crystal snowglobe that, when shaken, seems to form silhouettes of dancing forms",
            "half of a palm-sized geode that pulses dimly with purple light",
            "a book filled with writing that only appears when the book is held underwater",
            "a sealed envelope made of red leather that you haven’t been able to open it smells of campfire",
            "a locket of hair, glowing like embers, that is rumored to have come from a famed fire genasi",
            "a flint and steel firestriker, when used to start a fire, creates a random coloured flame",
            "a flint and steel firestriker that creates a blue flame when used to start a fire",
            "a flint and steel firestriker that creates a white flame when used to start a fire",
            "a flint and steel firestriker that creates a black flame when used to start a fire",
            "a flint and steel firestriker that creates a green flame when used to start a fire",
            "a flint and steel firestriker that creates a cold flame when used to start a fire",
            "a flint and steel firestriker that creates a sentient flame when used to start a fire. The flame is pretty friendly and makes a great travelling companion",
            "a flint and steel firestriker that creates a sentient flame when used to start a fire. The flame has a lawful good alignment that despises evildoers, especially the undead",
            "a flint and steel firestriker that creates a sentient flame when used to start a fire. The flame has a chaotic evil alignment that maniacally fantasises about fire and arson, and whispers to the wielder about setting things ablaze",
            "a blank piece of wet parchment that never seems to dry",
            "a small puzzle box made of brass, that is slightly warm to the touch",
            "a cloudy chunk of glass that is said to hold a spark of breath from a blue dragon",
            "a crude chalice made of coal",
            "a miniature brass horn, silent when played, but fills the air with the scent of warm and exotic spices",
            "an eye-sized blue pearl that floats in salt water",
            "a tuning fork made from a dark metal which glows with a pale, white light during thunderstorms",
            "a small vial that is always filled with the smell of autumn wind",
            "a clear marble that slowly rolls toward the nearest source of running water",
            "a small collapsible silver cup that perspires constantly when opened",
            "an hourglass that tells time with falling mist instead of sand",
            "an ornate razor, which only cuts in freezing cold temperature",
            "a shark tooth covered in tiny etched words from a lost language",
            "a large brass coin with no markings or images on it",
            "a small wooden box filled with a strange red clay",
            "a necklace with a small, rusted iron anchor",
            "a small brass flute adorned with silver wire that is always faintly sounding",
            "a red and black aarakocra feather",
            "a palm-sized stone with a hole in it, through which can be heard a constantly whispering wind",
            "a small conch shell covered in black crystal",
            "a small music box made of brass, that features a pair of tiny automatons that resemble azer working at a forge",
            "a glass jar containing the preserved corpse of an unfamiliar aquatic creature",
            "a piece of petrified wood carved into the shape of a seashell",
            "a wooden puzzle cube covered in elemental symbols. Opening the puzzle requires passing a DC20 intelligence check. Inside the puzzle is an emerald worth 100gp",
            "a small stone cube that acts as a magnet when placed against another stone",
            "a ring made of a white metal on the inside is a name etched in auran",
            "a bracelet made of silvered fish hooks",
            "a journal filled with poetry hand-written in primordial",
            "a yellow gemstone that glows dimly when a storm is nearby",
            "a charred chisel with an unfamiliar symbol stamped into its base",
            "a canteen filled with a foul smelling orange mud",
            "a faceless doll made of driftwood",
            "a heavy iron key bearing the name of a ship long lost to the sea",
            "a small jewelry box made from the shell of a turtle",
            "a chess piece fashioned to look like fire myrmidon",
            "a spinning top with an image of one of the four elements on each side",
            "a single hoop earring made of a porous red stone",
            "an arrowhead carved from sea salt",
            "a small comb made of blue coral",
            "seven small beads of sandstone on a string, all different colours",
            "a romance chapbook written in undercommon titled \"just one layer of grey\"",
            "a tiny, broken clockwork harpy",
            "an ivory whale statuette",
            "a fist-sized cog, covered in barnacles",
            "an eyepatch made of obsidian and a black leather cord",
            "a glass bottle with a tiny ship of unfamiliar design inside",
            "a small notebook that causes anything written in it to disappear after 1 hour",
            "a crystal lens made of ivory and gold that causes anything observed through it to appear to be surrounded by motes of multicoloured light",
            "a small golden pyramid inscribed with elven symbols and about the size of a walnut",
            "a cloak pin made from enamel in the shape of a butterfly; when you take the pin off, it turns into a real butterfly, and returns when you are ready to put your cloak back on again",
            "a golden compass that points toward the nearest portal to the feywild within 10 miles",
            "a small silver spinning top that, when spun, endlessly spins until interrupted",
            "a small songbird made of enamel, gold wire, and precious stone; uttering the songbird's name in elvish causes the trinket to emit that bird's birdsong",
            "a small enamel flower that, when put in one's hair, animates, tying back the wearer's hair with a living vine with flowers; plucking a single flower from this vine returns it to its inanimate form",
            "a golden compass that points toward the deepest desires of the bearer",
            "a stiletto dagger carved from jade",
            "a stiletto dagger with a fragile, hollow glass blade, filled with wyvern poison, that is razor sharp",
            "a hooded lantern that requires no oil and produces a blue flame",
            "a hooded lantern that requires no oil and produces a white flame",
            "a hooded lantern that requires no oil and produces a black flame",
            "a hooded lantern that requires no oil and produces a green flame",
            "a hooded lantern that requires no oil and produces a cold flame",
            "a hooded lantern that requires no oil and produces a sentient flame. The flame is pretty friendly and makes a great travelling companion",
            "a hooded lantern that requires no oil and produces a sentient flame with a lawful good alignment that despises evildoers, especially the undead",
            "a hooded lantern that requires no oil and produces a sentient flame with a chaotic evil alignment that maniacally fantasises about fire and arson, and constantly whispers things to the bearer about setting things ablaze",
            "a newspaper that features your own obituary",
            "a drinking cup filled with fresh ale that refills once emptied",
            "a drinking cup filled with fresh wine that refills once emptied",
            "a drinking cup filled with fresh cider that refills once emptied",
            "a cloak that flaps dramatically when danger is nearby",
            "a set of tartan bagpipes that make the wielder completely invisible, but only while they're being played",
            "a gold piece that when given away reappears in the users hand ten minutes later",
            "a pixie trapped in a jar"

            )

    }

    fun listTrinkets(): List<Trinket> {
        val trinketNames = listTrinketNames()
        val trinkets = trinketNames.map { trinketName ->
            Trinket(trinketName)
        }
        return trinkets
    }

    fun randomTrinket(trinkets:List<Trinket>): Trinket {
        return trinkets.random()

    }
    class Profession(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listProfessionNames(): List<String> {

        return listOf(
            "abjurer",
            "acolyte",
            "alchemist",
            "armourer",
            "assassin",
            "baker",
            "barbarian",
            "barber",
            "bard",
            "baron",
            "blacksmith",
            "brewer",
            "butcher",
            "carpenter",
            "circus freak",
            "cleric",
            "clothier",
            "cobbler",
            "conjurer",
            "conman",
            "cook",
            "cooper",
            "courtesan",
            "diviner",
            "doctor",
            "draper",
            "druid",
            "duke",
            "enchanter",
            "evoker",
            "falconer",
            "farrier",
            "farmhand",
            "fighter",
            "fisherman",
            "flautist",
            "fletcher",
            "furrier",
            "grocer",
            "gladiator",
            "guard",
            "herbalist",
            "hermit",
            "illusionist",
            "innkeeper",
            "jeweller",
            "knight",
            "labourer",
            "landlord",
            "lutist",
            "lyrist",
            "mercenary",
            "miller",
            "monk",
            "musician",
            "noble",
            "nurse",
            "outlander",
            "painter",
            "page",
            "paladin",
            "peasant",
            "pianist",
            "piper",
            "ploughman",
            "potter",
            "priest",
            "ranger",
            "rogue",
            "royal",
            "sailor",
            "slaver",
            "shaman",
            "shopkeeper",
            "silversmith",
            "soldier",
            "soothsayer",
            "sorcerer",
            "squire",
            "tailor",
            "tax collector",
            "transmuter",
            "urchin",
            "wainwright",
            "warlock",
            "whore",
            "wizard",
            "woodsman"

            )

    }

    fun listProfessions(): List<Profession> {
        val professionNames = listProfessionNames()
        val professions = professionNames.map { professionName ->
            Profession(professionName)
        }
        return professions
    }

    fun randomProfession(professions:List<Profession>): Profession {
        return professions.random()

    }

    class Wound(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listWoundNames(): List<String> {

        return listOf(
            "a broken nose",
            "a split lip",
            "a scar across the eye",
            "a broken finger",
            "a cracked rib",
            "a black eye",
            "a cut on the eyebrow",
            "a huge bruise on the stomach",
            "two teeth missing",
            "a chipped tooth",
            "soiled undergarments"

        )

    }

    fun listWounds(): List<Wound> {
        val woundNames = listWoundNames()
        val wounds = woundNames.map { woundName ->
            Wound(woundName)
        }
        return wounds
    }

    fun randomWound(wounds:List<Wound>): Wound {
        return wounds.random()

    }

    class Location(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listLocationNames(): List<String> {

        return listOf(
            "the town market",
            "a foul cave",
            "a sewer entrance",
            "the local lords private chambers",
            "a shady tavern",
            "a muddy ditch",
            "a nearby stable filled with oxen",
            "behind a cheap bordello",
            "the centre of a summoning circle in a nearby wizards tower",
            "a damp cellar",
            "the wilderness outside of town",
            "a dark alley",
            "a wooden cage in a kobold lair",
            "a wooden cage in a goblin lair",
            "a farmers wheatfield",
            "a ruined tower",
            "the tavernkeepers bed",
            "a velvet-lined coffin"

        )

    }

    fun listLocations(): List<Location> {
        val locationNames = listLocationNames()
        val locations = locationNames.map { locationName ->
            Location(locationName)
        }
        return locations
    }

    fun randomLocation(locations:List<Location>): Location {
        return locations.random()

    }

    class ShittyItem(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listShittyItemNames(): List<String> {

        return listOf(
            "a ring of cold resistance with a horrible curse giving the wearer a weakness to fire damage",
            "a ring of fire resistance with a horrible curse giving the wearer a weakness to cold damage",
            "a gold piece that when given away reappears in the users hand ten minutes later",
            "an orb of slope detection",
            "a journal that records the events of the day, but only from its own perspective",
            "a wand of create wand of create wand. It crumbles to dust after each use",
            "a ring of teleportation, set with an emerald shaped like an eye. When activated it teleports the ring (but not the bearer) to any location on the current plane",
            "an ornate plate armour set, which is haunted by the soul of a deceased knight and flees as soon as someone touches it",
            "the bagpipes of invisibility, which grant the wielder invisibility but only while the bagpipes are being played as loud as possible",
            "a 'ring of justice' that at first glance appears to grant some kind of holy boon, but actually has a curse that prevents the wearer from speaking a lie",
            "a cloak that flaps dramatically whenever your weapon is drawn",
            "a pair of eyeglasses with a steel frame and reflective, dark-tinted lenses that cause the wearer to grow a horseshoe moustache",
            "an doughnut shaped ioun stone with a meathook hanging from it. It hovers behind you and follows you around, but has no other effects besides being able to bear 50lb",
            "a pair of hardy and comfortable leather military boots that leave no footprints, but a horrible curse causes them to sink like rocks as soon as the wearer steps into water",
            "a potion labelled 'potion of healing' that expired years ago and is now horribly poisonous, first healing 2d4+2 points of healing but at midnight inflicting the effects of the 'midnight tears' poison",
            "a leather belt granting +1 intelligence and a curse that makes the bearer believe they're in some kind of game controlled by an all powerful overseer who watches down on everyone in the town and decides their fate and destiny by simple games of chance.\n\nEveryone else thinks the wearer has gone mad",
            "a blue glass wizards staff with a +1 bonus to spell attacks and spell save DC, but a curse that causes all spells cast by the bearer to target themselves, or the spot they are standing on",
            "a green longbow made of a strange flexible glass with a +1 magic bonus, but a curse that causes all arrows fired by the wielder to turn around and target themselves",
            "a mahogany shortbow with a +1 magic bonus that when aimed draws a red laser between the wielder and the target",
            "a mahogany longbow with a +1 magic bonus that when aimed draws a red laser between the wielder and the target",
            "a mahogany light crossbow with a +1 magic bonus that when aimed draws a red laser between the wielder and the target",
            "a mahogany heavy crossbow with a +1 magic bonus that when aimed draws a red laser between the wielder and the target",
            "a mahogany hand crossbow with a +1 magic bonus that when aimed draws a red laser between the wielder and the target",
            "a +3 greatsword with a horrible curse that causes the wounds it inflicts to also be inflicted on the bearer",
            "a javelin that isn't affected by the laws of gravity and will leave the atmosphere if nothing stops it",
            "a mysterious black ball with a fuse poking out of the top.\n\nOnce lit, it explodes three seconds later dealing 2d10 fire damage in a 20ft radius",
            "a mysterious black ball with a fuse poking out of the top.\n\nOnce lit, it explodes three seconds later dealing 2d10 fire damage in a 20ft radius, but also is cursed and weighs one ton once lit"

        )

    }

    fun listShittyItems(): List<ShittyItem> {
        val shittyItemNames = listShittyItemNames()
        val shittyItems = shittyItemNames.map { shittyItemName ->
            ShittyItem(shittyItemName)
        }
        return shittyItems
    }

    fun randomShittyItem(shittyItems:List<ShittyItem>): ShittyItem {
        return shittyItems.random()

    }

    class God(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listGodNames(): List<String> {

        return listOf(
            "Auril, neutral evil goddess of winter, who governs the domains of nature and the tempest and is represented by the symbol of a six-pointed snowflake",
            "Azuth, lawful neutral god of wizards, who governs the domain of knowledge and is represented by the symbol of a left hand pointing upward outlined in fire",
            "Bane, lawful evil god of tyranny, who governs the domain of war and is represented by the symbol of an upright black right hand, thumb and fingers together",
            "Beshaba, chaotic evil goddess of misfortune, who governs the domain of trickery and is represented by the symbol of a pair of black antlers",
            "Bhaal, neutral evil god of murder, who governs the domain of death and is represented by the symbol of a skull surrounded by a ring of blood droplets",
            "Chauntea, neutral good goddess of agriculture, who governs the domain of life and is represented by the symbol of a sheaf of wheat, sometimes covered with a blooming rose",
            "Cond, true neutral god of craft, who governs the domain of knowledge and is represented by the symbol of a toothed cog with four spokes",
            "Cyric, chaotic evil god of lies, who governs the domain of trickery and is represented by the symbol of a white jawless skull on black or purple sunburst",
            "Deneir, neutral good god of writing, who governs the domain of knowledge and is represented by the symbol of a lit candle above an open eye",
            "Eldath, chaotic good goddess of peace, who governs the domains of life and nature and is represented by the symbol of a waterfall plunging into still pool",
            "Helm, lawful neutral god of protection, who governs the domains of life and light and is represented by the symbol of a staring eye on upright left gauntlet",
            "Ilmater, lawful good god of endurance, who governs the domain of life and is represented by the symbol of hands bound at the wrist with red cord",
            "Kelemvor, lawful neutral god of the dead, who governs the domain of death and is represented by the symbol of an upright skeletal arm holding balanced scales",
            "Lathander, neutral good god of birth and renewal, who governs the domains of life and light and is represented by the symbol of a road traveling into a sunrise",
            "Leira, chaotic neutral goddess of illusion, who governs the domain of trickery and is represented by the symbol of a point-down triangle containing a swirl of mist",
            "Lliira, chaotic good goddess of joy, who governs the domain of life and is represented by the symbol of a triangle of three six-pointed stars",
            "Lolth, chaotic evil queen of spiders, who goddess of the drow governs the domain of trickery and is represented by a black spider with crimson eyes",
            "Loviatar, lawful evil goddess of pain, who governs the domain of death and is represented by the symbol of a nine-tailed barbed scourge",
            "Malar, chaotic evil god of the hunt, who governs the domain of nature and is represented by the symbol of a clawed paw",
            "Mask, chaotic neutral god of thieves, who governs the domain of trickery and is represented by the symbol of a black mask",
            "Mielikki, neutral good goddess of forests, who governs the domain of nature and is represented by the symbol of a unicorn’s head",
            "Milil, neutral good god of poetry and song, who governs the domain of light and is represented by the symbol of a five-stringed harp made of leaves",
            "Myrkul, neutral evil god of death, who governs the domain of death and is represented by the symbol of a white human skull",
            "Mystra, neutral good goddess of magic, who governs the domain of knowledge and is represented by the symbol of a circle of seven stars",
            "Oghma, true neutral god of knowledge, who governs the domain of knowledge and is represented by the symbol of a blank scroll",
            "Savras, lawful neutral god of divination and fate, who governs the domain of knowledge and is represented by the symbol of a crystal ball containing many kinds of eyes",
            "Selûne, chaotic good goddess of the moon, who governs the domains of knowledge and life and is represented by the symbol of a pair of eyes surrounded by seven stars",
            "Shar, neutral evil goddess of darkness and loss, who governs the domains of death and trickery and is represented by the symbol of a black disk encircled with a border",
            "Silvanus, true neutral god of wild nature, who governs the domain of nature and is represented by the symbol of an oak leaf",
            "Sune, chaotic good goddess of love and beauty, who governs the domains of life and light and is represented by the symbol of a face of a beautiful red-haired woman",
            "Talona, chaotic evil goddess of disease and poison, who governs the domain of death and is represented by the symbol of three teardrops on a triangle",
            "Talos, chaotic evil god of storms, who governs the domain of the tempest and is represented by the symbol of three lightning bolts radiating from a central point",
            "Tempus, true neutral god of war, who governs the domain of war and is represented by the symbol of an upright flaming sword",
            "Torm, lawful good god of courage and self-sacrifice, who governs the domain of war and is represented by the symbol of a white gauntlet from a right hand",
            "Tymora, chaotic good goddess of good fortune, who governs the domain of trickery and is represented by the symbol of a face-up coin",
            "Tyr, lawful good god of justice, who governs the domain of war and is represented by the symbol of balanced scales resting on a warhammer",
            "Umberlee, chaotic evil goddess of the sea, who governs the domain of the tempest and is represented by the symbol of a wave curling left and right",
            "Waukeen, true neutral goddess of trade, who governs the domain of knowledge and trickery and is represented by the symbol of an upright coin with Waukeen’s profile facing left"

            )

    }

    fun listGods(): List<God> {
        val godNames = listGodNames()
        val gods = godNames.map { godName ->
            God(godName)
        }
        return gods
    }

    fun randomGod(gods:List<God>): God {
        return gods.random()

    }

    class BodyPart(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listBodyPartNames(): List<String> {

        return listOf(
            "neck",
            "left forearm",
            "left shoulder",
            "left thigh",
            "left shin",
            "left buttock",
            "right forearm",
            "right shoulder",
            "right thigh",
            "right shin",
            "right buttock",
            "chest",
            "left hand",
            "right hand",
            "stomach",
            "upper back",
            "lower back",
            "forehead"

        )

    }

    fun listBodyParts(): List<BodyPart> {
        val bodyPartNames = listBodyPartNames()
        val bodyParts = bodyPartNames.map { bodyPartName ->
            BodyPart(bodyPartName)
        }
        return bodyParts
    }

    fun randomBodyPart(bodyParts:List<BodyPart>): BodyPart {
        return bodyParts.random()

    }

    class Game(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listGameNames(): List<String> {

        return listOf(
            "a darts",
            "a drinking",
            "a pool",
            "an arm-wrestling",
            "a poker",
            "a pull-up",
            "a singing",
            "a dancing",
            "a pub quiz",
            "a billiards",
            "a skittles",
            "a quoits",
            "a bowls",
            "a farkle",
            "a liars dice"

        )

    }

    fun listGames(): List<Game> {
        val gameNames = listGameNames()
        val games = gameNames.map { gameName ->
            Game(gameName)
        }
        return games
    }

    fun randomGame(games:List<Game>): Game {
        return games.random()

    }

    class Pet(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listPetNames(): List<String> {

        return listOf(
            "a black cat licking",
            "a fruit bat licking",
            "a giant snail slithering on",
            "a capuchin monkey licking",
            "a cane toad ribbiting by",
            "a raven standing on",
            "a pigeon standing on",
            "a vampire bat standing on",
            "a huge rat cuddled up to",
            "a tomcat licking",
            "a tabby cat licking",
            "an alsatian puppy licking",
            "a slobbery bulldog puppy licking",
            "a chihuahua licking",
            "a golden retriever puppy licking",
            "a collie dog puppy licking",
            "a sugar glider licking",
            "a ferret licking",
            "a pixie in a bottle next to",
            "a fairy in a jam jar next to",
            "a snake licking",
            "a tarantula dangling above",
            "a chameleon curled up against",
            "a monitor lizard curled up against",
            "a pseudodragon laying next to"

        )

    }

    fun listPets(): List<Pet> {
        val petNames = listPetNames()
        val pets = petNames.map { petName ->
            Pet(petName)
        }
        return pets
    }

    fun randomPet(pets:List<Pet>): Pet {
        return pets.random()

    }

    class Nickname(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listNicknameNames(): List<String> {

        val races = listRaces()

        return listOf(
            "Schmitty",
            "Gudgeon",
            "Woad",
            "the ${randomRace(races)}-lover",
            "the ${randomRace(races)}-hunter",
            "the ${randomRace(races)}-hater",
            "Billy Big-Balls",
            "Edgewalker",
            "Chicken Chaser",
            "Arseface",
            "Captain",
            "Sir",
            "Madam",
            "Milord",
            "Harper",
            "Snake",
            "Coxwattle",
            "the Destroyer",
            "Secretstealer",
            "Lionheart",
            "Dragonheart",
            "Porkchop",
            "the Butcher",
            "the Crimson",
            "Spellslinger",
            "Blackblade",
            "Ratlick",
            "Ghost",
            "Devildriver",
            "Preacher",
            "Strongarm",
            "Doc",
            "Maverick",
            "Iceman",
            "Goose",
            "Wererat",
            "Werewolf",
            "Werebear",
            "Wereraven",
            "Pieface",
            "the Patriot",
            "the Blademaster",
            "the Repentant",
            "the Bastard",
            "the Fainthearted",
            "the Ironwilled",
            "the Reaper",
            "the Holy",
            "the Unholy",
            "the Fool",
            "the Fat",
            "the Farseer",
            "the Rotten",
            "the Gutlord",
            "the Magnificent",
            "the Grey",
            "the White",
            "the Red",
            "the Blue",
            "the Green",
            "the Black",
            "the Yellow",
            "the Dark",
            "the Kind",
            "the Cruel",
            "the Flatulent",
            "the Light",
            "the one who lived",
            "the dead",
            "khan",
            "Scratchy",
            "Scurvy",
            "Snake-tongue",
            "Wildling",
            "Fancypants",
            "Beefy",
            "the Tightfisted",
            "Greedy",
            "Greedy-guts"

        )

    }

    fun listNicknames(): List<Nickname> {
        val nicknameNames = listNicknameNames()
        val nicknames = nicknameNames.map { nicknameName ->
            Nickname(nicknameName)
        }
        return nicknames
    }

    fun randomNickname(nicknames:List<Nickname>): Nickname {
        return nicknames.random()

    }

    class Animal(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listAnimalNames(): List<String> {

        val races = listRaces()

        return listOf(
            "a talking turnip with your own facial features",
            "a talking pig",
            "a talking cow",
            "a talking chicken",
            "an unspeakably hideous ${randomRace(races)}",
            "a ${randomRace(races)} child",
            "a tiny version of yourself, no bigger than a foot tall",
            "a talking lizard",
            "a talking crow",
            "a talking pigeon",
            "a talking horse",
            "a talking twenty-sided dice. (Being rolled is absolutely terrifying for you)",
            "a talking twenty-sided dice. (Being rolled is incredibly pleasurable for you)",
            "a talking twenty-sided dice. (Being rolled is pleasurable if the number is above eleven, and painful if ten or below)",
            "a talking donkey",
            "a talking flagon",
            "a talking saddle",
            "a goblin",
            "a kobold",
            "a talking snake",
            "a talking rat",
            "a talking mouse",
            "a talking ferret",
            "a talking cockroach",
            "a talking locust",
            "a talking toad",
            "a talking frog",
            "a talking bat",
            "a talking chair with your own facial features",
            "a talking treasure chest with your own facial features",
            "a talking greatsword with your own facial features",
            "a talking shield with your own facial features"

        )

    }

    fun listAnimals(): List<Animal> {
        val animalNames = listAnimalNames()
        val animals = animalNames.map { animalName ->
            Animal(animalName)
        }
        return animals
    }

    fun randomAnimal(animals:List<Animal>): Animal {
        return animals.random()

    }

    class Myth(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listMythNames(): List<String> {

        return listOf(
            "a knight of the fey realm",
            "an archdemon",
            "a demigod",
            "a black dragon",
            "a blue dragon",
            "a red dragon",
            "a green dragon",
            "a white dragon",
            "a brass dragon",
            "a bronze dragon",
            "a copper dragon",
            "a gold dragon",
            "a silver dragon",
            "a shapeshifter",
            "a pixie",
            "a fairy",
            "a vampire lord",
            "a werewolf",
            "a mimic",
            "a ruler of a distant land",
            "a sentient weapon that was granted the body of its master as he died",
            "an undercover operative from the ruling lord, investigating a series of events that sound awfully similar to your quest so far",
            "a powerful archmage",
            "a pig under the effect of a powerful polymorph spell",
            "from the future",
            "from a parallel plane",
            "your child from a distant future",
            "you, but from the future",
            "your ancient ancestor from the past",
            "a legendary thief",
            "heir to the throne of waterdeep",
            "heir to the throne of baldurs gate",
            "heir to the throne of neverwinter",

        )

    }

    fun listMyths(): List<Myth> {
        val mythNames = listMythNames()
        val myths = mythNames.map { mythName ->
            Myth(mythName)
        }
        return myths
    }

    fun randomMyth(myths:List<Myth>): Myth {
        return myths.random()

    }

    class Guild(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listGuildNames(): List<String> {

        val races = listRaces()

        return listOf(
            "scriveners guild",
            "esoteric brotherhood of fishmongers",
            "rotary club",
            "homeowners association",
            "${randomRace(races)}kind liberation front",
            "poorfellow soldiers of Bahamut and the temple of King Galbatorix",
            "health potion brewers and apothecaries union",
            "union of madams, brotheliers, and bordello and whorehouse administrators",
            "lords alliance",
            "emerald enclave",
            "zhentarim",
            "stonecutters",
            "order of the gauntlet",
            "harpers",
            "socialist workers party of Faerun",

            )

    }

    fun listGuilds(): List<Guild> {
        val guildNames = listGuildNames()
        val guilds = guildNames.map { guildName ->
            Guild(guildName)
        }
        return guilds
    }

    fun randomGuild(guilds:List<Guild>): Guild {
        return guilds.random()

    }

    class HotOrNot(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listHotOrNotNames(): List<String> {

        return listOf(
            "unspeakably hideous",
            "grotesque",
            "ugly",
            "homely",
            "not attractive",
            "average looking",
            "quite attractive",
            "beautiful",
            "stunningly beautiful",
            "way out of your league"

        )

    }

    fun listHotOrNots(): List<HotOrNot> {
        val hotOrNotNames = listHotOrNotNames()
        val hotOrNots = hotOrNotNames.map { hotOrNotName ->
            HotOrNot(hotOrNotName)
        }
        return hotOrNots
    }

    fun randomHotOrNot(hotOrNots:List<HotOrNot>): HotOrNot {
        return hotOrNots.random()

    }

    class Mount(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listMountNames(): List<String> {

        val races = listRaces()

        return listOf(
            "palamino riding horse named 'Rocínante' that once belonged to a famous knight. The steed looks a little past it's prime",
            "fully barded black warhorse named 'Bucephalus', with incredible musculature wearing a white caparison embroidered with a golden sunburst",
            "camel named 'Omar' who spits at each ${randomRace(races)} you pass by",
            "trained dire wolf named 'Winter' that growls that anyone wearing a hat or helmet",
            "trained stag named 'Beren' that speaks sylvan, but not until he hears sylvan being spoken around him first",
            "donkey named 'Donald'. Donald was once a court jester who was polymorphed by a powerful archmage",
            "workhorse named 'Spud' who looks ready for the glue factory",
            "paint racehorse named 'Edicius', with an exquisitely crafted saddle",
            "a huge, lumbering Ox named 'Beefy', that comes complete with a covered-top wagon",
            "tiny pony named 'Tiffin'",
            "paint riding horse named 'Bandit' who you constantly catch trying to eat your parties rations"

        )

    }

    fun listMounts(): List<Mount> {
        val mountNames = listMountNames()
        val mounts = mountNames.map { mountName ->
            Mount(mountName)
        }
        return mounts
    }

    fun randomMount(mounts:List<Mount>): Mount {
        return mounts.random()

    }

    class Weapon(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listWeaponNames(): List<String> {

        return listOf(
            "battleaxe",
            "blowgun",
            "dagger",
            "dart",
            "flail",
            "glaive",
            "greataxe",
            "greatsword",
            "halberd",
            "hand crossbow",
            "hatchet",
            "heavy crossbow",
            "javelin",
            "katana",
            "light crossbow",
            "light hammer",
            "longbow",
            "longsword",
            "mace",
            "maul",
            "morningstar",
            "pair of knuckle dusters",
            "pike",
            "polearm",
            "rapier",
            "scimitar",
            "shield",
            "shortbow",
            "shortsword",
            "sickle",
            "spear",
            "trident",
            "war pick",
            "warhammer",
            "whip",
            "wizards staff",

        )

    }

    fun listWeapons(): List<Weapon> {
        val weaponNames = listWeaponNames()
        val weapons = weaponNames.map { weaponName ->
            Weapon(weaponName)
        }
        return weapons
    }

    fun randomWeapon(weapons:List<Weapon>): Weapon {
        return weapons.random()

    }

    class WeaponMaterial(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listWeaponMaterialNames(): List<String> {

        return listOf(
            "a slightly damaged",
            "a worn",
            "a brand new",
            "an old",
            "an ancient",
            "a finely crafted",
            "a jewel-encrusted",
            "a dwarven",
            "an elven",
            "a shining",
            "a spectral",
            "an adamantine",
            "a mithril",
            "a bone",
            "a smoking",
            "a flaming",
            "an indestructible glass",
            "a rusted",
            "a jet black",
            "an obsidian",
            "a translucent",
            "a large",
            "a small",

            )

    }

    fun listWeaponMaterials(): List<WeaponMaterial> {
        val weaponMaterialNames = listWeaponMaterialNames()
        val weaponMaterials = weaponMaterialNames.map { weaponMaterialName ->
            WeaponMaterial(weaponMaterialName)
        }
        return weaponMaterials
    }

    fun randomWeaponMaterial(weaponMaterials:List<WeaponMaterial>): WeaponMaterial {
        return weaponMaterials.random()

    }

    class WeaponMod(
        private val name: String
    ){
        override fun toString(): String {
            return name
        }
    }

    fun listWeaponModNames(): List<String> {

        val race = listRaces()

        return listOf(

            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus",
            "with a +1 magic bonus and your name engraved on it",
            "with a +1 magic bonus enchanted with a blue 'continual flame'",
            "with a +1 magic bonus enchanted with a red 'continual flame'",
            "with a +1 magic bonus enchanted with a greed 'continual flame'",
            "with a +1 magic bonus enchanted with a black 'continual flame'",
            "with a +1 magic bonus enchanted with a white 'continual flame'",
            "with a +1 magic bonus enchanted with a pink 'continual flame'",
            "with a +1 magic bonus enchanted with a violet 'continual flame'",
            "with a +1 magic bonus enchanted with a 'continual flame' that cycles through colours",
            "with a +1 magic bonus that vibrates when unsheathed",
            "with a +2 magic bonus enchanted with 'continual flame'",
            "with a +2 magic bonus enchanted with 'continual flame'",
            "with a +2 bonus but a horrible curse that paralyses the wielder whenever their heart rate rises above a resting level",
            "with a +1 magic bonus and causes the wielders cloak and hair to flap dramatically when a ${randomRace(race)} is nearby",
            "with a +1 magic bonus and glows with 10ft of dim blue light when an orc, goblin or undead creature is nearby",
            "with a +1 magic bonus that returns to the wielder if thrown",
            "with a +1 magic bonus that screams maniacally when wielded in combat",
            "with a +1 magic bonus that can seamlessly retract into its hilt by a small button",
            "with a +1 magic bonus that secretly longs to return to its maker, and twitches whenever it thinks they might be nearby. It's exceptionally paranoid.",
            "with a +1 magic bonus that a giant used to use as a kitchen utensil",
            "with a +1 magic bonus that has a flute built into it",
            "with a +1 magic bonus and a perfect mirror polish and can never be tarnished",
            "with a +1 magic bonus that can be transformed into any simple or martial weapon by a button on its hilt",
            "with a +2 magic bonus that was previously owned by a famous knight",
            "with a +2 magic bonus and a perfect mirror polish that can never be tarnished",
            "with a +2 magic bonus that turns any living creature it slays into ice",
            "with a +2 magic bonus that turns any living creature it slays into stone",
            "with a +2 magic bonus that turns any living creature it slays into ash",
            "with a +2 magic bonus that returns to the wielder if thrown",
            "with a +2 bonus and a horrible curse that harmlessly skeletonises the first hand to touch it",
            "with a +2 magic bonus and a lawful good sentience that sings the theme tune from Shaft (but with the wielders name) whenever you're chasing a criminal, and Sabotage by the Beastie Boys whenever you kick in a door",
            "with a +2 magic bonus and a chaotic evil alignment that craves blood, and publicly chastises you with horrible insults whenever you miss with an attack roll or fail a skill check",
            "with a +3 magic bonus, wreathed in a green flame that radiates 10ft of dim light, bearing the hallmark of it's crafter, Dûrin Deepfire",
            "with a +3 magic bonus, does double damage to undead, and radiates 5ft of dim white light",
            "with a +3 magic bonus and a perfect mirror polish that can never be tarnished"

        )

    }

    fun listWeaponMods(): List<WeaponMod> {
        val weaponModNames = listWeaponModNames()
        val weaponMods = weaponModNames.map { weaponModName ->
            WeaponMod(weaponModName)
        }
        return weaponMods
    }

    fun randomWeaponMod(weaponMods:List<WeaponMod>): WeaponMod {
        return weaponMods.random()

    }


}