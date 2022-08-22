package com.theloneguy.plugins.noregisterauth.ActionManager;

import java.time.Instant;

public class DetailsUpdater {

    /*

    Objectid: id
    id: br-id
    exit: exit-coords
    lastlogin: last-login-time
    loginip: ip
    name: CaSeSeNsEtIvE Name
    register ip: never change
    session: 1
    username: Name
    uuid: mc_uuid
    created: timeStamp

     */

    public void ExitCoordsUpdater(String x, String y, String z) {
        //value update
    }

    public void LastLoginTimeStampUpdater() {

        long now = Instant.now().getEpochSecond();
//value update

    }

    public void UUIDUpdater(String username, String uuid) {
        //value update
    }

}
