:CAR_FOLLOWER
0004: $BEING_FOLLOWED = 1
0004: $FOLLOW_CAR_DESTROYED = 0
03A4: name_thread 'SPYCAR'
0111: set_wasted_busted_check_to 0 

0247: request_model $FOLLOW_CAR_MODEL
0247: request_model $FOLLOW_DRIVER_MODEL

while true
	if or
		8248:   not model $FOLLOW_CAR_MODEL available 
		8248:   not model $FOLLOW_DRIVER_MODEL available 
	jf break
	wait 0 ms
end //while

// Create the car
03D3: get_closest_car_node_at $FOLLOW_CAR_START_X $FOLLOW_CAR_START_Y -100.0 store_to $FOLLOW_CAR_START_X $FOLLOW_CAR_START_Y $FOLLOW_CAR_START_Z heading $FOLLOW_CAR_START_ANGLE
00A5: $FOLLOW_CAR = create_car $FOLLOW_CAR_MODEL at $FOLLOW_CAR_START_X $FOLLOW_CAR_START_Y $FOLLOW_CAR_START_Z
02AA: set_car $FOLLOW_CAR immune_to_nonplayer 1 
020A: set_car $FOLLOW_CAR door_status_to CARLOCK_LOCKED 
02AC: set_car $FOLLOW_CAR immunities 1 1 1 0 0 // Bulletproof, Fireproof, Explosion-proof
0175: set_car $FOLLOW_CAR z_angle_to $FOLLOW_CAR_START_ANGLE
0129: $FOLLOW_DRIVER = create_actor PEDTYPE_GANG_COLOMBIAN $FOLLOW_DRIVER_MODEL in_car $FOLLOW_CAR driverseat 

// Car AI
00A8: car_wander_randomly $FOLLOW_CAR

while 01FC:   player $PLAYER_CHAR near_car $FOLLOW_CAR radius 200.0 200.0 unknown 0 // Follower has not lost the player
	wait 0 ms
	if
		01FC:   player $PLAYER_CHAR near_car $FOLLOW_CAR radius 30.0 30.0 unknown 0 // Follower close, blend in with normal traffic, don't follow player.
	then
		00A8: car_wander_randomly $FOLLOW_CAR
	else

		// From this point all ranges will have to follow the player
		0054: get_player_coordinates $PLAYER_CHAR store_to $PLAYER_X $PLAYER_Y $PLAYER_Z
		00A7: car_goto_coordinates $FOLLOW_CAR coords $PLAYER_X $PLAYER_Y $PLAYER_Z
		00AE: set_car_driving_style $FOLLOW_CAR to DRIVINGMODE_AVOIDCARS

		if
			01FC:   player $PLAYER_CHAR near_car $FOLLOW_CAR radius 70.0 70.0 unknown 0 // Try to catch up level 1.
		then
			00AD: set_car_cruise_speed $FOLLOW_CAR to 50.0 
		else
			if
				01FC:   player $PLAYER_CHAR near_car $FOLLOW_CAR radius 120.0 120.0 unknown 0 // Try to catch up level 2.
			then
				00AD: set_car_cruise_speed $FOLLOW_CAR to 75.0 	
			end
		end
	end

	// If the follower is dead, the player is no longer followed. 
	// Also needed to prevent the game from crashing due to checking a non-existent vehicle.
	if
		0119:   car $FOLLOW_CAR wrecked
	then
		0004: $FOLLOW_CAR_DESTROYED = 1
		goto @CAR_FOLLOWER_CLEANUP
	end

	// The player didnt lose the follower at the point he should have, mission failed!
	if
		0038:   $SHAKE_FOLLOW_CAR_FAILED == 1
	then
		goto @CAR_FOLLOWER_CLEANUP
	end
end //while

// At this point the follower has lost the player.
goto @CAR_FOLLOWER_CLEANUP

////////////////////////////////////////

:CAR_FOLLOWER_CLEANUP
00A6: delete_car $FOLLOW_CAR
0004: $BEING_FOLLOWED = 0
01C3: remove_references_to_car $FOLLOW_CAR
01C2: remove_references_to_actor $FOLLOW_DRIVER
0249: release_model $FOLLOW_CAR_MODEL
0249: release_model $FOLLOW_DRIVER_MODEL
end_thread
