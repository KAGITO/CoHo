class CreateReplies < ActiveRecord::Migration
  def change
    create_table :replies do |t|
      t.integer :micropost_id
      t.text :body
      t.references :user, index: true, foreign_key: true

      t.timestamps null: false
    end
    add_index :replies, :micropost_id
  end
end
