import { useMemo } from 'react';

import { QueryClient } from 'react-query';

export const useQueryClient = () => {
  return useMemo(
    () =>
      new QueryClient({
        defaultOptions: {
          queries: {
            refetchOnWindowFocus: false,
            staleTime: 1000 * 60 * 5, // 5 minutes
          },
        },
      }),
    []
  );
};
