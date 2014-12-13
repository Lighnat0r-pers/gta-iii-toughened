CONST
// <constant name> = <constant value>

//driving styles
DRIVINGMODE_STOPFORCARS = 0
DRIVINGMODE_SLOWDOWNFORCARS = 1
DRIVINGMODE_AVOIDCARS = 2

//door statuses
CARLOCK_UNLOCKED = 1
CARLOCK_LOCKED = 2
CARLOCK_LOCKOUT_PLAYER_ONLY = 3
CARLOCK_LOCKED_PLAYER_INSIDE = 4
CARLOCK_FORCE_SHUT_DOORS = 6

//carbomb statuses
CARBOMB_TIMED = 1
CARBOMB_ONIGNITION = 2
CARBOMB_REMOTE = 3
CARBOMB_TIMEDACTIVE = 4
CARBOMB_ONIGNITIONACTIVE = 5

//vehicles
ALL_CARS = -2
CAR_LANDSTALKER = 90
CAR_IDAHO = 91
CAR_STINGER = 92
CAR_LINERUNNER = 93
CAR_PERENNIAL = 94
CAR_SENTINEL = 95
CAR_PATRIOT = 96
CAR_FIRETRUCK = 97
CAR_TRASH = 98
CAR_STRETCH = 99
CAR_MANANA = 100
CAR_INFERNUS = 101
CAR_BLISTA = 102
CAR_PONY = 103
CAR_MULE = 104
CAR_CHEETAH = 105
CAR_AMBULANCE = 106
CAR_FBI = 107
CAR_MOONBEAM = 108
CAR_ESPERANTO = 109
CAR_TAXI = 110
CAR_KURUMA = 111
CAR_BOBCAT = 112
CAR_MRWHOOPY = 113
CAR_BFINJECTION = 114
CAR_CORPSE = 115
CAR_POLICE = 116
CAR_ENFORCER = 117
CAR_SECURICAR = 118
CAR_BANSHEE = 119
BOAT_PREDATOR = 120
CAR_BUS = 121
CAR_RHINO = 122
CAR_BARRACKS = 123
TRAIN_SUBWAY = 124
HELI_POLICE = 125
PLANE_DODO = 126
CAR_COACH = 127
CAR_CABBIE = 128
CAR_STALLION = 129
CAR_RUMPO = 130
CAR_RCBANDIT = 131
PLANE_AIRTRAIN = 140
PLANE_DEADDODO = 141
BOAT_SPEEDER = 142
BOAT_REEFER = 143
CAR_FLATBED = 145
CAR_YANKEE = 146

//car colours
CARCOLOUR_BLACK = 0

//pedtypes
PEDTYPE_CIVMALE = 4
PEDTYPE_CIVFEMALE = 5
PEDTYPE_COP = 6
PEDTYPE_GANG_MAFIA = 7
PEDTYPE_GANG_TRIAD = 8
PEDTYPE_GANG_DIABLO = 9
PEDTYPE_GANG_YAKUZA = 10
PEDTYPE_GANG_YARDIE = 11
PEDTYPE_GANG_COLOMBIAN = 12
PEDTYPE_GANG_HOOD = 13
PEDTYPE_BUM = 19
PEDTYPE_PROSTITUTE = 20
PEDTYPE_SPECIAL = 21

//peds
// PED_GANG_COLOMBIAN_A = #GANG11

//pedstats
PEDSTAT_GEEK_GUY = 14
PEDSTAT_TOUGH_GUY = 16

//weapon types
WEAPONTYPE_UNARMED = 0
WEAPONTYPE_BASEBALLBAT = 1
WEAPONTYPE_PISTOL = 2
WEAPONTYPE_UZI = 3
WEAPONTYPE_SHOTGUN = 4
WEAPONTYPE_CHAINGUN = 5
WEAPONTYPE_M16 = 6
WEAPONTYPE_SNIPERRIFLE = 7
WEAPONTYPE_ROCKET = 8
WEAPONTYPE_FLAMETHROWER = 9
WEAPONTYPE_MOLOTOV = 10
WEAPONTYPE_GRENADE = 11
WEAPONTYPE_DETONATOR = 12
WEAPONTYPE_RUNOVERBYCAR = 17
WEAPONTYPE_UZI_DRIVEBY = 19

//threats
THREAT_PLAYER1 = 1
THREAT_PLAYER2 = 2
THREAT_PLAYER3 = 4
THREAT_PLAYER4 = 8
THREAT_CIVMALE = 16
THREAT_CIVFEMALE = 32
THREAT_COP = 64
THREAT_GANG_MAFIA = 128
THREAT_GANG_TRIAD = 256
THREAT_GANG_DIABLO = 512
THREAT_GANG_YAKUZA = 1024
THREAT_GANG_YARDIE = 2048
THREAT_GANG_COLOMBIAN = 4096
THREAT_GANG_HOOD = 8192
THREAT_EMERGENCY = 65536
THREAT_PROSTITUTE = 131072
THREAT_CRIMINAL = 262144
THREAT_SPECIAL = 524288
THREAT_GUN = 1048576
THREAT_COP_CAR = 2097152
THREAT_FAST_CAR = 4194304
THREAT_FIREMAN = 16777216
THREAT_DEADPEDS = 33554432

//camera modes
BEHINDCAR = 3
FIXED = 15

//camera switchstyles
INTERPOLATION = 1
JUMP_CUT = 2

//control pads
PAD1 = 0

//keys
START = 12
SQUARE = 14
CROSS = 16
RIGHTSHOCK = 19

//animations (waitstates)
WAITSTATE_FALSE = 0
WAITSTATE_CROSS_ROAD_LOOK = 3
WAITSTATE_PLAYANIM_DUCK = 14
WAITSTATE_PLAYANIM_CHAT = 19

//animations (walkstyles)
ANIM_GANG2_PED = 9
ANIM_SEXY_WOMANPED = 15
ANIM_PANIC_CHUNKYPED = 18

//explosions
EXPLOSION_GRENADE = 0
EXPLOSION_CAR = 3
EXPLOSION_HELI = 5

//radar icons
RADAR_SPRITE_ASUKA = 1
RADAR_SPRITE_BOMB = 2
RADAR_SPRITE_CAT = 3
RADAR_SPRITE_CENTRE = 4
RADAR_SPRITE_COPCAR = 5
RADAR_SPRITE_DON = 6
RADAR_SPRITE_EIGHT = 7
RADAR_SPRITE_DIABLO = 8
RADAR_SPRITE_HOOD = 9
RADAR_SPRITE_JOEY = 10
RADAR_SPRITE_KENJI = 11
RADAR_SPRITE_YARDIE = 12
RADAR_SPRITE_LUIGI = 13
RADAR_SPRITE_NORTH = 14
RADAR_SPRITE_RAY = 15
RADAR_SPRITE_SAL = 16
RADAR_SPRITE_SAVE = 17
RADAR_SPRITE_SPRAY = 18
RADAR_SPRITE_TONY = 19
RADAR_SPRITE_WEAPON = 20

//blip display
MARKER_ONLY = 1
BLIP_ONLY = 2
BOTH = 3

//hud items
HUD_FLASH_HEALTH = 4
HUD_FLASH_RADAR = 8

//time of day
DAY = 1
NIGHT = 0

//weather
WEATHER_SUNNY = 0
WEATHER_CLOUDY = 1
WEATHER_RAINY = 2
WEATHER_FOGGY = 3

//particles
POBJECT_PAVEMENT_STEAM_SLOWMOTION = 1
POBJECT_WALL_STEAM_SLOWMOTION = 3
POBJECT_DARK_SMOKE = 4
PARTICLE_BLOOD_SMALL = 5
POBJECT_DRY_ICE = 11
POBJECT_DRY_ICE_SLOWMOTION = 12
POBJECT_FIRE_TRAIL = 13
POBJECT_FIREBALL_AND_SMOKE = 15
POBJECT_CATALINAS_GUNFLASH = 18
POBJECT_CATALINAS_SHOTGUNFLASH = 19
PARTICLE_TEST = 65

//shadows
SHADOW_EXPLOSION = 3

//islands
LEVEL_INDUSTRIAL = 1 // Portland
LEVEL_COMMERCIAL = 2 // Staunton
LEVEL_SUBURBAN = 3 // Shoreside Vale

//sounds
sound_test_1 = 0
SOUND_STRIP_CLUB_LOOP_1_S = 30
SOUND_STRIP_CLUB_LOOP_2_S = 32
SOUND_SAWMILL_LOOP_L = 37
SOUND_PORN_CINEMA_1_S = 62
SOUND_PORN_CINEMA_2_S = 64
SOUND_PORN_CINEMA_3_S = 66
SOUND_RAVE_LOOP_INDUSTRIAL_L = 73
SOUND_INJURED_PED_MALE_OUCH_S = 78
SOUND_INJURED_PED_MALE_OUCH_L = 79
SOUND_INJURED_PED_FEMALE_OUCH_S = 80
SOUND_INJURED_PED_FEMALE_OUCH_L = 81
SOUND_EVIDENCE_PICKUP = 82
SOUND_GATE_START_CLUNK = 92
SOUND_GATE_STOP_CLUNK = 93
SOUND_PART_MISSION_COMPLETE = 94
SOUND_CHUNKY_RUN_SHOUT = 95
SOUND_SECURITY_GUARD_RUN_AWAY_SHOUT = 96
SOUND_SWAT_PED_SHOUT = 101
SOUND_PRETEND_FIRE_LOOP = 102
SOUND_AMMUNATION_CHAT_1 = 103
SOUND_AMMUNATION_CHAT_2 = 104
SOUND_AMMUNATION_CHAT_3 = 105

//radio stations
HEAD_RADIO = 0
DOUBLE_CLEFF_FM = 1
RISE_FM = 3

//pickups
PICKUP_IN_SHOP = 1
PICKUP_ON_STREET = 2
PICKUP_ONCE = 3
PICKUP_OUT_OF_STOCK = 6
PICKUP_ON_STREET_SLOW = 14

//corona types
CORONATYPE_HEX = 5

//flare types
FLARETYPE_NONE = 0

//car missions
MISSION_NONE = 0
MISSION_CRUISE = 1
MISSION_RAMPLAYER_FARAWAY = 2
MISSION_RAMPLAYER_CLOSE = 3
MISSION_BLOCKPLAYER_FARAWAY = 4
MISSION_BLOCKPLAYER_CLOSE = 5
MISSION_BLOCKPLAYER_HANDBRAKESTOP = 6
MISSION_WAITFORDELETION = 7
MISSION_GOTOCOORDS = 8
MISSION_GOTOCOORDS_STRAIGHT = 9
MISSION_EMERGENCYVEHICLE_STOP = 10
MISSION_STOP_FOREVER = 11
MISSION_GOTOCOORDS_ACCURATE = 12
MISSION_GOTOCOORDS_STRAIGHT_ACCURATE = 13
MISSION_GOTOCOORDS_ASTHECROWSWIMS = 14
MISSION_RAMCAR_FARAWAY = 15
MISSION_RAMCAR_CLOSE = 16
MISSION_BLOCKCAR_FARAWAY = 17
MISSION_BLOCKCAR_CLOSE = 18
MISSION_BLOCKCAR_HANDBRAKESTOP = 19

//status text
COUNTER_DISPLAY_NUMBER = 0
COUNTER_DISPLAY_BAR = 1

//garages
GARAGE_MISSION = 1
GARAGE_BOMBSHOP_TIMED = 2
GARAGE_BOMBSHOP_ONIGNITION = 3
GARAGE_BOMBSHOP_REMOTE = 4
GARAGE_PAYNSPRAY = 5
GARAGE_COLLECTSPECIFICCARS = 7
GARAGE_IMPORT_PORTLAND = 8
GARAGE_IMPORT_SHORESIDE = 9
GARAGE_MISSION_REJECTCAR = 11
GARAGE_MISSION_KEEPCAR = 14
GARAGE_SAVEONE = 16
GARAGE_SAVETWO = 17
GARAGE_SAVETHREE = 18
GARAGE_FOR_SCRIPT_TO_OPEN_AND_CLOSE = 19
GARAGE_MISSION_REJECTCAR_STAYOPEN = 20
GARAGE_MISSION_KEEPCAR_REMAINCLOSED = 21

//gangs
GANG_MAFIA = 0
GANG_TRIAD = 1
GANG_DIABLO = 2
GANG_YAKUZA = 3
GANG_YARDIE = 4
GANG_COLOMBIAN = 5
GANG_HOOD = 6
GANG_COP = 7


//colours
RED = 0

//follow route
FOLLOW_ROUTE_BACKFORWARD = 2

//kill frenzy status
FRENZY_ONGOING = 1
FRENZY_PASSED = 2
FRENZY_FAILED = 3

END
