using WebStore.Data.Entities.Identity;

namespace WebStore.Services
{
    public interface IJwtTokenService
    {
        Task<string> CreateToken(UserEntity user);
    }
}
