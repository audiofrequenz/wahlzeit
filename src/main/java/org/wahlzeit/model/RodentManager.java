package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class RodentManager extends ObjectManager {

    protected static final RodentManager instance = new RodentManager();
    protected HashMap<Integer, RodentType> rodentTypes = new HashMap<>();
    protected HashMap<Integer, Rodent> rodents = new HashMap<>();
    public static RodentManager getInstance() {
        return instance;
    }

    public Rodent createRodent(RodentType rodentType, String name) {
        RodentType rt = this.rodentTypes.get(rodentTypes.hashCode());
        Rodent r = rt.createInstance(name);
        rodents.put(r.hashCode(), r);
        return r;
    }

    protected RodentType getOrCreateRodentType(String rodentSpecies, int averageWeight) {
        //staticAssertIsValidArgument(carOEMName);
        //staticAssertIsValidArgument(model);
        int rodentHash = new RodentType(rodentSpecies, averageWeight).hashCode();
        if (rodentTypes.get(rodentHash) != null) {
            return rodentTypes.get(rodentHash);
        }
        return rodentTypes.put(rodentHash, new RodentType(rodentSpecies, averageWeight));
    }

    //unnessesarry only there because extends ObjectManager referenced in UML => not needed...
    @Override
    protected Persistent createObject(ResultSet rset) throws SQLException {
        return null;
    }
}
