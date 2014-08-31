:ALL_REWARDS
0004: $EARNED_FREE_PISTOL = 0 
0004: $EARNED_FREE_UZI = 0 
0004: $EARNED_FREE_ARMOUR = 0 
0004: $EARNED_FREE_SHOTGUN = 0 
0004: $EARNED_FREE_GRENADES = 0 
0004: $EARNED_FREE_MOLOTOVS = 0 
0004: $EARNED_FREE_AK47 = 0 
0004: $EARNED_FREE_SNIPER = 0 
0004: $EARNED_FREE_M16 = 0 
0004: $EARNED_FREE_LAUNCHER = 0 
0004: $BONUS_WEAPONS_CREATED = 0  
03A4: name_thread 'IMPORT'
0111: set_wasted_busted_check_to 0 
wait 100 ms
create_thread @PACKAGE_SNIFFER

if
    0038:   $DEBUGPACKAGESCOMPLETED == 1 
then
    0004: $EARNED_FREE_PISTOL = 1 
    0004: $EARNED_FREE_UZI = 1 
    0004: $EARNED_FREE_ARMOUR = 1 
    0004: $EARNED_FREE_SHOTGUN = 1 
    0004: $EARNED_FREE_GRENADES = 1 
    0004: $EARNED_FREE_MOLOTOVS = 1 
    0004: $EARNED_FREE_AK47 = 1 
    0004: $EARNED_FREE_SNIPER = 1 
    0004: $EARNED_FREE_M16 = 1 
    0004: $EARNED_FREE_LAUNCHER = 1 
end

while true
	wait 500 ms
	if
		0256:   is_player $PLAYER_CHAR defined 
	then
		if
			03C6:   current_island == LEVEL_INDUSTRIAL
		then
			if
				0121:   player $PLAYER_CHAR in_zone 'REDLIGH'  // Red Light District
			then
				if
					0057:   is_player_in_area_3d $PLAYER_CHAR coords 828.875 -283.75 0.0 to 894.1875 -323.5 26.0 sphere 0 
				then
					if
						0038:   $BONUS_WEAPONS_CREATED == 0
					then
						0213: $HIDEOUT_BAT = create_pickup #BAT type PICKUP_ON_STREET at 883.5 -302.0625 8.0 
						if
							0038:   $EARNED_FREE_PISTOL == 1
						then
							032B: $BONUS_GUN1 = create_weapon_pickup #COLT45 type PICKUP_ON_STREET_SLOW ammo 90 at 876.75 -317.0625 10.0
						end
						if
							0038:   $EARNED_FREE_UZI == 1
						then
							032B: $BONUS_GUN2 = create_weapon_pickup #UZI type PICKUP_ON_STREET_SLOW ammo 250 at 874.75 -317.0625 10.0 
						end
						if
							0038:   $EARNED_FREE_GRENADES == 1
						then
							032B: $BONUS_GUN3 = create_weapon_pickup #GRENADE type PICKUP_ON_STREET_SLOW ammo 10 at 872.75 -317.0625 10.0
						end
						if
							0038:   $EARNED_FREE_SHOTGUN == 1
						then
							032B: $BONUS_GUN4 = create_weapon_pickup #SHOTGUN type PICKUP_ON_STREET_SLOW ammo 50 at 870.75 -317.0625 10.0 
						end
						if
							0038:   $EARNED_FREE_ARMOUR == 1
						then
							0213: $BONUS_GUN5 = create_pickup #BODYARMOUR type PICKUP_ON_STREET_SLOW at 868.75 -317.0625 10.0 
						end
						if
							0038:   $EARNED_FREE_MOLOTOVS == 1
						then
							032B: $BONUS_GUN6 = create_weapon_pickup #MOLOTOV type PICKUP_ON_STREET_SLOW ammo 10 at 866.75 -317.0625 10.0 
						end
						if
							0038:   $EARNED_FREE_AK47 == 1
						then
							032B: $BONUS_GUN7 = create_weapon_pickup #AK47 type PICKUP_ON_STREET_SLOW ammo 300 at 864.75 -317.0625 10.0 
						end
						if
							0038:   $EARNED_FREE_SNIPER == 1
						then
							032B: $BONUS_GUN8 = create_weapon_pickup #SNIPER type PICKUP_ON_STREET_SLOW ammo 50 at 862.75 -317.0625 10.0 
						end
						if
							0038:   $EARNED_FREE_M16 == 1
						then
							032B: $BONUS_GUN9 = create_weapon_pickup #M16 type PICKUP_ON_STREET_SLOW ammo 600 at 860.75 -317.0625 10.0 
						end
						if
							0038:   $EARNED_FREE_LAUNCHER == 1
						then
							032B: $BONUS_GUN10 = create_weapon_pickup #ROCKET type PICKUP_ON_STREET_SLOW ammo 50 at 856.75 -317.0625 10.0 
						end
						0004: $BONUS_WEAPONS_CREATED = 1
					end
				else	//	player is not in area (828.9 -283.8 0.0 894.2 -323.5 26.0)
					if
						0038:   $BONUS_WEAPONS_CREATED == 1
					then
						gosub @REMOVE_BONUS_PICKUPS
					end
				end
			else	//	player is not in REDLIGH
				if
					0038:   $BONUS_WEAPONS_CREATED == 1
				then
					gosub @REMOVE_BONUS_PICKUPS
				end
			end
		end

		if
			03C6:   current_island == LEVEL_COMMERCIAL 
		then
			if
				0121:   player $PLAYER_CHAR in_zone 'PARK'  // Belleville Park
			then
				if
					0057:   is_player_in_area_3d $PLAYER_CHAR coords 39.5 -443.75 53.0 to 167.5 -484.5625 15.0 sphere 0 
				then
					if
						0038:   $BONUS_WEAPONS_CREATED == 0
					then
						0213: $HIDEOUT_BAT = create_pickup #BAT type PICKUP_ON_STREET at 99.0625 -478.6875 15.875 
						if
							0038:   $EARNED_FREE_PISTOL == 1
						then
							032B: $BONUS_GUN1 = create_weapon_pickup #COLT45 type PICKUP_ON_STREET_SLOW ammo 90 at 132.6875 -477.875 15.875
						end
						if
							0038:   $EARNED_FREE_UZI == 1
						then
							032B: $BONUS_GUN2 = create_weapon_pickup #UZI type PICKUP_ON_STREET_SLOW ammo 250 at 132.6875 -479.875 15.875 
						end
						if
							0038:   $EARNED_FREE_GRENADES == 1
						then
							032B: $BONUS_GUN3 = create_weapon_pickup #GRENADE type PICKUP_ON_STREET_SLOW ammo 10 at 129.0625 -477.875 15.875 
						end
						if
							0038:   $EARNED_FREE_SHOTGUN == 1
						then
							032B: $BONUS_GUN4 = create_weapon_pickup #SHOTGUN type PICKUP_ON_STREET_SLOW ammo 50 at 129.0625 -479.875 15.875 
						end
						if
							0038:   $EARNED_FREE_ARMOUR == 1
						then
							0213: $BONUS_GUN5 = create_pickup #BODYARMOUR type PICKUP_ON_STREET_SLOW at 125.5625 -477.875 15.875 
						end
						if
							0038:   $EARNED_FREE_MOLOTOVS == 1
						then
							032B: $BONUS_GUN6 = create_weapon_pickup #MOLOTOV type PICKUP_ON_STREET_SLOW ammo 10 at 125.5625 -479.875 15.875 
						end
						if
							0038:   $EARNED_FREE_AK47 == 1
						then
							032B: $BONUS_GUN7 = create_weapon_pickup #AK47 type PICKUP_ON_STREET_SLOW ammo 300 at 122.0625 -477.875 15.875 
						end
						if
							0038:   $EARNED_FREE_SNIPER == 1
						then
							032B: $BONUS_GUN8 = create_weapon_pickup #SNIPER type PICKUP_ON_STREET_SLOW ammo 50 at 122.0625 -479.875 15.875 
						end
						if
							0038:   $EARNED_FREE_M16 == 1
						then
							032B: $BONUS_GUN9 = create_weapon_pickup #M16 type PICKUP_ON_STREET_SLOW ammo 600 at 118.6875 -477.875 15.875 
						end
						if
							0038:   $EARNED_FREE_LAUNCHER == 1
						then
							032B: $BONUS_GUN10 = create_weapon_pickup #ROCKET type PICKUP_ON_STREET_SLOW ammo 50 at 125.5625 -475.875 15.875 
						end
						0004: $BONUS_WEAPONS_CREATED = 1
					end
				else	//	player is not in area (39.5 -443.8 53.0 167.5 -484.6 15.0)
					if
						0038:   $BONUS_WEAPONS_CREATED == 1
					then
						gosub @REMOVE_BONUS_PICKUPS
					end
				end
			else	//	player is not in PARK
				if
					0038:   $BONUS_WEAPONS_CREATED == 1
				then
					gosub @REMOVE_BONUS_PICKUPS
				end
			end
		end

		if
			03C6:   current_island == LEVEL_SUBURBAN
		then
			if
				0121:   player $PLAYER_CHAR in_zone 'PROJECT'  // Wichita Gardens
			then
				if
					0057:   is_player_in_area_3d $PLAYER_CHAR coords -595.75 -68.1875 10.0 to -700.6875 3.0625 30.0 sphere 0 
				then
					if
						$BONUS_WEAPONS_CREATED == 0
					then
						0213: $HIDEOUT_BAT = create_pickup #BAT type PICKUP_ON_STREET at -661.0625 -3.75 18.75
						if
							0038:   $EARNED_FREE_PISTOL == 1
						then
							032B: $BONUS_GUN1 = create_weapon_pickup #COLT45 type PICKUP_ON_STREET_SLOW ammo 90 at -650.5 -24.75 18.75 
						end
						if
							0038:   $EARNED_FREE_UZI == 1
						then
							032B: $BONUS_GUN2 = create_weapon_pickup #UZI type PICKUP_ON_STREET_SLOW ammo 250 at -648.5 -24.75 18.75 
						end
						if
							0038:   $EARNED_FREE_GRENADES == 1
						then
							032B: $BONUS_GUN3 = create_weapon_pickup #GRENADE type PICKUP_ON_STREET_SLOW ammo 10 at -646.5 -24.75 18.75 
						end
						if
							0038:   $EARNED_FREE_SHOTGUN == 1
						then
							032B: $BONUS_GUN4 = create_weapon_pickup #SHOTGUN type PICKUP_ON_STREET_SLOW ammo 50 at -644.5 -24.75 18.75 
						end
						if
							0038:   $EARNED_FREE_ARMOUR == 1
						then
							0213: $BONUS_GUN5 = create_pickup #BODYARMOUR type PICKUP_ON_STREET_SLOW at -642.5 -24.75 18.75 
						end
						if
							0038:   $EARNED_FREE_MOLOTOVS == 1
						then
							032B: $BONUS_GUN6 = create_weapon_pickup #MOLOTOV type PICKUP_ON_STREET_SLOW ammo 10 at -640.5 -24.75 18.75 

						end
						if
							0038:   $EARNED_FREE_AK47 == 1
						then
							032B: $BONUS_GUN7 = create_weapon_pickup #AK47 type PICKUP_ON_STREET_SLOW ammo 300 at -638.5 -24.75 18.75 
						end
						if
							0038:   $EARNED_FREE_SNIPER == 1
						then
							032B: $BONUS_GUN8 = create_weapon_pickup #SNIPER type PICKUP_ON_STREET_SLOW ammo 50 at -636.5 -24.75 18.75 
						end
						if
							0038:   $EARNED_FREE_M16 == 1
						then
							032B: $BONUS_GUN9 = create_weapon_pickup #M16 type PICKUP_ON_STREET_SLOW ammo 600 at -634.5 -24.75 18.75 
						end
						if
							0038:   $EARNED_FREE_LAUNCHER == 1
						then
							032B: $BONUS_GUN10 = create_weapon_pickup #ROCKET type PICKUP_ON_STREET_SLOW ammo 50 at -630.5 -24.75 18.75 
						end
						0004: $BONUS_WEAPONS_CREATED = 1
					end
				else	//	player is not in area (-595.8 -68.2 10.0 -700.7 3.1 30.0)
					if
						0038:   $BONUS_WEAPONS_CREATED == 1
					then
						gosub @REMOVE_BONUS_PICKUPS
					end
				end
			else	//	player is not in PROJECT
				if
					0038:   $BONUS_WEAPONS_CREATED == 1
				then
					gosub @REMOVE_BONUS_PICKUPS
				end
			end
		end
	end
end

:REMOVE_BONUS_PICKUPS
0215: destroy_pickup $HIDEOUT_BAT
0215: destroy_pickup $BONUS_GUN1 
0215: destroy_pickup $BONUS_GUN2 
0215: destroy_pickup $BONUS_GUN3 
0215: destroy_pickup $BONUS_GUN4 
0215: destroy_pickup $BONUS_GUN5 
0215: destroy_pickup $BONUS_GUN6 
0215: destroy_pickup $BONUS_GUN7 
0215: destroy_pickup $BONUS_GUN8 
0215: destroy_pickup $BONUS_GUN9 
0215: destroy_pickup $BONUS_GUN10 
0004: $BONUS_WEAPONS_CREATED = 0  
return



