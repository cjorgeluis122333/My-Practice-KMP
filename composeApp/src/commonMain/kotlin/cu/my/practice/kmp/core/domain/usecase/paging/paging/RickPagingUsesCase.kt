package cu.my.practice.kmp.core.domain.usecase.paging.paging

interface RickPagingUsesCase<E> {
   operator fun invoke():E
}