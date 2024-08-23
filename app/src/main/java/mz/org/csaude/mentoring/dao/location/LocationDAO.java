package mz.org.csaude.mentoring.dao.location;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import java.util.List;

import mz.org.csaude.mentoring.model.location.Location;

@Dao
public interface LocationDAO {

    @Query("SELECT * FROM location WHERE uuid = :uuid")
    List<Location> checkLocation(String uuid);

    @Query("SELECT * FROM location WHERE employee_id = :employeeId")
    List<Location> getAllOfEmployee(int employeeId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLocation(Location location);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLocations(List<Location> locations);
}
