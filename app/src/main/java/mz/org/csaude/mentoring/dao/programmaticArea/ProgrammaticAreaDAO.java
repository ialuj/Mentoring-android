package mz.org.csaude.mentoring.dao.programmaticArea;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import java.util.List;

import mz.org.csaude.mentoring.model.programmaticArea.ProgrammaticArea;

@Dao
public interface ProgrammaticAreaDAO {

    @Insert
    void insert(ProgrammaticArea programmaticArea);

    @Update
    void update(ProgrammaticArea programmaticArea);

    @Delete
    void delete(ProgrammaticArea programmaticArea);

    @Query("SELECT * FROM programmatic_area WHERE id = :id")
    ProgrammaticArea getById(int id);

    @Query("SELECT * FROM programmatic_area")
    List<ProgrammaticArea> getAll();

    @Query("SELECT * FROM programmatic_area WHERE uuid = :uuid LIMIT 1")
    ProgrammaticArea getByUuid(String uuid);
}
