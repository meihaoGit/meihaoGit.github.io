module Jekyll
  module GitHubMetadata
    class Pages
      class << self
        DEFAULTS = {
          'PAGES_ENV'             => 'dotcom'.freeze,
          'PAGES_API_URL'         => 'https://api.github.com'.freeze,
          'PAGES_HELP_URL'        => 'https://help.github.com'.freeze,
          'PAGES_GITHUB_HOSTNAME' => 'github.com'.freeze,
          'PAGES_PAGES_HOSTNAME'  => 'github.io'.freeze,
          'SSL'                   => 'false'.freeze,
          'SUBDOMAIN_ISOLATION'   => 'false'.freeze
        }.freeze

        # Whether the GitHub instance supports HTTPS
        # Note: this will be the same as how sites are served in Enterprise,
        # but may be different from how sites are served on GitHub.com.
        # See Repository#url_scheme
        def ssl?
          env_var('SSL') == 'true' || test?
        end

        def scheme
          ssl? ? "https" : "http"
        end

        def subdomain_isolation?
          env_var('SUBDOMAIN_ISOLATION').eql? 'true'
        end

        def test?;       env == 'test' end
        def dotcom?;     env == 'dotcom' end
        def enterprise?; env == 'enterprise' end

        def custom_domains_enabled?
          dotcom? || test?
        end

        def env
          env_var 'PAGES_ENV'
        end

        def github_url
          if dotcom?
            "https://github.com".freeze
          else
            "#{scheme}://#{github_hostname}"
          end
        end

        def api_url
          trim_last_slash env_var('PAGES_API_URL', ENV['API_URL'])
        end

        def help_url
          trim_last_slash env_var('PAGES_HELP_URL', ENV['HELP_URL'])
        end

        def github_hostname
          trim_last_slash env_var('PAGES_GITHUB_HOSTNAME', ENV['GITHUB_HOSTNAME'])
        end

        def pages_hostname
          trim_last_slash env_var('PAGES_PAGES_HOSTNAME', ENV['PAGES_HOSTNAME'])
        end

        private
        def env_var(key, intermediate_default = nil)
          !ENV[key].to_s.empty? ? ENV[key] : (intermediate_default || DEFAULTS[key])
        end

        def trim_last_slash(url)
          if url[-1] == "/"
            url[0..-2]
          else
            url
          end
        end
      end
    end
  end
end