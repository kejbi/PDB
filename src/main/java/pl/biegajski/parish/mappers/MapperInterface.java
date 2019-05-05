package pl.biegajski.parish.mappers;

public interface MapperInterface <Entity, View>{
    public View convertToViewModel(Entity entity);

    public Entity convertToEntity(View view);
}
